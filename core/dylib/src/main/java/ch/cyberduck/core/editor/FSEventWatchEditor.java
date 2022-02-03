package ch.cyberduck.core.editor;

/*
 * Copyright (c) 2012 David Kocher. All rights reserved.
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
 * Bug fixes, suggestions and comments should be sent to:
 * dkocher@cyberduck.ch
 */

import ch.cyberduck.core.Local;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.ProgressListener;
import ch.cyberduck.core.io.watchservice.FSEventWatchService;
import ch.cyberduck.core.local.Application;
import ch.cyberduck.core.local.FileWatcher;
import ch.cyberduck.core.local.FileWatcherListener;
import ch.cyberduck.core.pool.SessionPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import com.google.common.util.concurrent.Uninterruptibles;

/**
 * An editor listing for file system notifications on a particular folder
 */
public class FSEventWatchEditor extends AbstractEditor {
    private static final Logger log = LogManager.getLogger(FSEventWatchEditor.class);

    private final FileWatcher monitor
        = new FileWatcher(new FSEventWatchService());

    /**
     * With custom editor for file type.
     *
     * @param application Editor application
     * @param file        Remote file
     */
    public FSEventWatchEditor(final Application application, final SessionPool session,
                              final Path file, final ProgressListener listener) {
        super(application, session, file, listener);
    }

    public void watch(final Local local, final FileWatcherListener listener) throws IOException {
        Uninterruptibles.awaitUninterruptibly(monitor.register(local.getParent(), new FileWatcher.DefaultFileFilter(local), listener));
    }

    @Override
    public void close() {
        if(log.isDebugEnabled()) {
            log.debug(String.format("Close monitor %s", monitor));
        }
        monitor.close();
    }
}
