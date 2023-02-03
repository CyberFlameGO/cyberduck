package ch.cyberduck.core.editor;

/*
 * Copyright (c) 2002-2014 David Kocher. All rights reserved.
 * http://cyberduck.io/
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
 * feedback@cyberduck.io
 */

import ch.cyberduck.core.Host;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.ProgressListener;
import ch.cyberduck.core.local.Application;

import java.util.Collections;
import java.util.List;

public class DefaultEditorFactory extends EditorFactory {

    @Override
    protected List<Application> getConfigured() {
        return Collections.emptyList();
    }

    @Override
    public Editor create(final Host host, final Path file, final ProgressListener listener) {
        return new DefaultWatchEditor(host, file, listener);
    }
}
