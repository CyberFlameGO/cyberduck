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

import java.io.OutputStream;

public class VoidStatusOutputStream extends StatusOutputStream<Void> {

    public VoidStatusOutputStream(final OutputStream proxy) {
        super(proxy);
    }

    @Override
    public Void getStatus() throws BackgroundException {
        // No remote attributes from server returned after upload
        return null;
    }
}
