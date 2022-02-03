package ch.cyberduck.core.s3;

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

import ch.cyberduck.core.features.Location;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.RedirectException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.protocol.HttpContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jets3t.service.ServiceException;
import org.jets3t.service.utils.ServiceUtils;

public class S3BucketRegionRedirectStrategy extends DefaultRedirectStrategy {
    private static final Logger log = LogManager.getLogger(S3BucketRegionRedirectStrategy.class);

    private final RequestEntityRestStorageService requestEntityRestStorageService;
    private final S3Session session;
    private final RequestEntityRestStorageService authorizer;

    public S3BucketRegionRedirectStrategy(final RequestEntityRestStorageService requestEntityRestStorageService, final S3Session session, final RequestEntityRestStorageService authorizer) {
        this.requestEntityRestStorageService = requestEntityRestStorageService;
        this.session = session;
        this.authorizer = authorizer;
    }

    @Override
    public HttpUriRequest getRedirect(final HttpRequest request, final HttpResponse response, final HttpContext context) throws ProtocolException {
        if(response.containsHeader("x-amz-bucket-region")) {
            final Header header = response.getFirstHeader("x-amz-bucket-region");
            log.warn(String.format("Received redirect response %s with %s", response, header));
            final String uri = StringUtils.replaceEach(request.getRequestLine().getUri(),
                    session.getHost().getProtocol().getRegions().stream().map(Location.Name::getIdentifier).toArray(String[]::new),
                    session.getHost().getProtocol().getRegions().stream().map(location -> header.getValue()).toArray(String[]::new));
            final HttpUriRequest redirect = RequestBuilder.copy(request).setUri(uri).build();
            log.warn(String.format("Retry request with URI %s", redirect.getURI()));
            try {
                authorizer.authorizeHttpRequest(redirect, context, null);
            }
            catch(ServiceException e) {
                throw new RedirectException(e.getMessage(), e);
            }
            // Update cache with new region
            if(StringUtils.isEmpty(RequestEntityRestStorageService.findBucketInHostname(session.getHost()))) {
                requestEntityRestStorageService.getRegionEndpointCache().putRegionForBucketName(ServiceUtils.findBucketNameInHostname(((HttpUriRequest) request).getURI().getHost(),
                        requestEntityRestStorageService.getJetS3tProperties().getStringProperty("s3service.s3-endpoint", session.getHost().getHostname())), header.getValue());
            }
            else {
                requestEntityRestStorageService.getRegionEndpointCache().putRegionForBucketName(
                        RequestEntityRestStorageService.findBucketInHostname(session.getHost()), header.getValue());
            }
            return redirect;
        }
        return super.getRedirect(request, response, context);
    }
}
