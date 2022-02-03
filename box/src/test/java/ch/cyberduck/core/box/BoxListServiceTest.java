package ch.cyberduck.core.box;

/*
 * Copyright (c) 2002-2021 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.AlphanumericRandomStringService;
import ch.cyberduck.core.AttributedList;
import ch.cyberduck.core.DisabledListProgressListener;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathAttributes;
import ch.cyberduck.core.exception.NotfoundException;
import ch.cyberduck.core.io.Checksum;
import ch.cyberduck.core.transfer.TransferStatus;
import ch.cyberduck.test.IntegrationTest;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.EnumSet;

import static ch.cyberduck.core.AbstractPath.Type.directory;
import static org.junit.Assert.*;

@Category(IntegrationTest.class)
public class BoxListServiceTest extends AbtractBoxTest {

    @Test
    public void testListRoot() throws Exception {
        final BoxFileidProvider fileid = new BoxFileidProvider(session);
        final AttributedList<Path> list = new BoxListService(session, fileid).list(
            new Path("/", EnumSet.of(directory, Path.Type.volume)), new DisabledListProgressListener());
        assertFalse(list.isEmpty());
        for(Path f : list) {
            assertNotEquals(TransferStatus.UNKNOWN_LENGTH, f.attributes().getSize());
            assertNotNull(f.attributes().getFileId());
            if(f.isFile()) {
                assertNotEquals(Checksum.NONE, f.attributes().getChecksum());
            }
            assertTrue(f.attributes().getModificationDate() > 0);
            assertTrue(f.attributes().getCreationDate() > 0);
        }
    }

    @Test(expected = NotfoundException.class)
    public void testNotFound() throws Exception {
        final BoxFileidProvider fileid = new BoxFileidProvider(session);
        new BoxListService(session, fileid).list(new Path(new AlphanumericRandomStringService().random(), EnumSet.of(directory)), new DisabledListProgressListener());
    }
}
