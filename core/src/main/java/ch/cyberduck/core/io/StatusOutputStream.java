package ch.cyberduck.core.io;

/*
 * Copyright (c) 2002-2016 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
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
 */

import ch.cyberduck.core.exception.BackgroundException;

import org.apache.commons.io.output.ProxyOutputStream;

import java.io.OutputStream;

public abstract class StatusOutputStream<Reply> extends ProxyOutputStream {

    public StatusOutputStream(final OutputStream proxy) {
        super(proxy);
    }

    /**
     * Obtain server status response after closing stream. Must close the stream first to prevent deadlock.
     *
     * @return Return the response after closing the stream.
     */
    public abstract Reply getStatus() throws BackgroundException;
}
