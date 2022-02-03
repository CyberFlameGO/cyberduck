package ch.cyberduck.core;

/*
 * Copyright (c) 2002-2013 David Kocher. All rights reserved.
 * http://cyberduck.ch/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to feedback@cyberduck.ch
 */

import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.threading.DefaultFailureDiagnostics;
import ch.cyberduck.core.transfer.DisabledTransferErrorCallback;
import ch.cyberduck.core.transfer.TransferErrorCallback;
import ch.cyberduck.core.transfer.TransferItem;
import ch.cyberduck.core.transfer.TransferStatus;

import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TransferErrorCallbackControllerFactory extends Factory<TransferErrorCallback> {
    private static final Logger log = LogManager.getLogger(TransferErrorCallbackControllerFactory.class);

    public TransferErrorCallbackControllerFactory() {
        super("factory.transfererrorcallback.class");
    }

    public TransferErrorCallback create(final Controller c) {
        try {
            final Constructor<TransferErrorCallback> constructor = ConstructorUtils.getMatchingAccessibleConstructor(clazz, c.getClass());
            if(null == constructor) {
                log.warn(String.format("No matching constructor for parameter %s", c.getClass()));
                // Call default constructor for disabled implementations
                return clazz.newInstance();
            }
            return constructor.newInstance(c);
        }
        catch(InstantiationException | InvocationTargetException | IllegalAccessException e) {
            log.error(String.format("Failure loading callback class %s. %s", clazz, e.getMessage()));
            return new DisabledTransferErrorCallback();
        }
    }

    /**
     * @param c Window controller
     * @return Login controller instance for the current platform.
     */
    public static TransferErrorCallback get(final Controller c) {
        final TransferErrorCallback proxy = new TransferErrorCallbackControllerFactory().create(c);
        return new TransferErrorCallback() {
            @Override
            public boolean prompt(final TransferItem item, final TransferStatus status, final BackgroundException failure, final int pending) throws BackgroundException {
                switch(new DefaultFailureDiagnostics().determine(failure)) {
                    case cancel:
                        // Interrupt transfer
                        return false;
                }
                if(pending == 0) {
                    // Fail fast when first item in queue fails preparing
                    throw failure;
                }
                if(pending == 1) {
                    // Fail fast when transferring single file
                    throw failure;
                }
                synchronized(proxy) {
                    return proxy.prompt(item, status, failure, pending);
                }
            }
        };
    }
}
