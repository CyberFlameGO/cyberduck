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

import ch.cyberduck.core.VoidAttributesAdapter;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.InteroperabilityException;
import ch.cyberduck.core.http.HttpResponseOutputStream;
import ch.cyberduck.core.transfer.TransferStatus;

import org.apache.commons.io.output.NullOutputStream;
import org.junit.Test;

public class DefaultStreamCloserTest {

    @Test(expected = InteroperabilityException.class)
    public void testClose() throws Exception {
        new DefaultStreamCloser().close(new HttpResponseOutputStream<Void>(NullOutputStream.NULL_OUTPUT_STREAM,
                new VoidAttributesAdapter(),
                new TransferStatus()) {
            @Override
            public Void getStatus() throws BackgroundException {
                throw new InteroperabilityException("d");
            }
        });
    }
}
