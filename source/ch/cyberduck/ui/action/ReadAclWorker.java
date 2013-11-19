package ch.cyberduck.ui.action;

/*
 * Copyright (c) 2002-2010 David Kocher. All rights reserved.
 *
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

import ch.cyberduck.core.Acl;
import ch.cyberduck.core.LocaleFactory;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.ConnectionCanceledException;
import ch.cyberduck.core.features.AclPermission;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @version $Id$
 */
public abstract class ReadAclWorker extends Worker<List<Acl.UserAndRole>> {

    private AclPermission feature;

    private List<Path> files;

    public ReadAclWorker(final AclPermission feature, final List<Path> files) {
        this.feature = feature;
        this.files = files;
    }

    @Override
    public List<Acl.UserAndRole> run() throws BackgroundException {
        final List<Acl.UserAndRole> updated = new ArrayList<Acl.UserAndRole>();
        for(Path next : files) {
            if(this.isCanceled()) {
                throw new ConnectionCanceledException();
            }
            if(Acl.EMPTY.equals(next.attributes().getAcl())) {
                next.attributes().setAcl(feature.getPermission(next));
            }
            for(Acl.UserAndRole acl : next.attributes().getAcl().asList()) {
                if(updated.contains(acl)) {
                    continue;
                }
                updated.add(acl);
            }
        }
        return updated;
    }

    @Override
    public String getActivity() {
        return MessageFormat.format(LocaleFactory.localizedString("Getting permission of {0}", "Status"),
                this.toString(files));
    }

    @Override
    public List<Acl.UserAndRole> initialize() {
        return Collections.emptyList();
    }

    @Override
    public boolean equals(final Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        final ReadAclWorker that = (ReadAclWorker) o;
        if(files != null ? !files.equals(that.files) : that.files != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return files != null ? files.hashCode() : 0;
    }
}
