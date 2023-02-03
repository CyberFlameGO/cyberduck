package ch.cyberduck.core.threading;

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

import ch.cyberduck.core.preferences.PreferencesFactory;

import java.util.concurrent.BlockingQueue;

public class DispatchThreadPool extends ExecutorServiceThreadPool implements ThreadPool {

    public DispatchThreadPool() {
        super(new DispatchExecutorService());
    }

    public DispatchThreadPool(final String prefix, final int size, final Priority priority, final BlockingQueue<Runnable> queue, final Thread.UncaughtExceptionHandler handler) {
        super(PreferencesFactory.get().getInteger("threading.pool.size.max") == size ? new DispatchExecutorService() :
                DefaultThreadPool.createExecutor(prefix, size, priority, queue, new DefaultThreadPool.CustomCallerPolicy(), handler));
    }
}
