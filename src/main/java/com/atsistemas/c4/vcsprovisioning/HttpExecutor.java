package com.atsistemas.c4.vcsprovisioning;
/*
import com.atlassian.stash.rest.client.api.StashException;
import com.atlassian.stash.rest.client.core.http.HttpExecutor;
import com.atlassian.stash.rest.client.core.http.HttpRequest;
import com.atlassian.stash.rest.client.core.http.HttpResponse;
import com.atlassian.stash.rest.client.core.http.HttpResponseProcessor;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;

import com.atsistemas.c4.vcsprovision.entity.ProvisionData;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;


public class HttpClientHttpExecutor implements HttpExecutor {

    private final DefaultHttpClient httpClient;
    private final URL baseUrl;
    private final BasicHttpContext forceBasicAuthContext;

    public HttpClientHttpExecutor(@Nonnull ProvisionData config) {
        try {
            this.baseUrl = new URI(config.getVcsURL());

        } catch (Exception e) {
            //TODO añadir manejo de excepción


        }
        this.httpClient = new DefaultHttpClient();
        this.forceBasicAuthContext = new BasicHttpContext();

        initCredentials(config);
    }

    private void initCredentials(ProvisionData config) {
        URL hostUrl = null;
        if (!Strings.isNullOrEmpty(config.getVcsUser())) {
            try {
                hostUrl = new URL(config.getVcsURI());

            } catch (Exception e) {
                 //TODO añadir manejo de excepción
            }

            String scheme = Objects.firstNonNull(hostUrl.getProtocol(), "http");
            int port = hostUrl.getPort() != -1 ? hostUrl.getPort() : ("https".equalsIgnoreCase(scheme) ? 443 : 80);
            HttpHost targetHost = new HttpHost(hostUrl.getHost(), port, scheme);

            // add credentials to credentials provider
            Credentials credentials = new UsernamePasswordCredentials(config.getUsername(), config.getPassword());
            httpClient.getCredentialsProvider().setCredentials(new AuthScope(targetHost), credentials);

            // force Basic Auth headers for requests
            AuthCache authCache = new BasicAuthCache();
            BasicScheme basicAuth = new BasicScheme();
            authCache.put(targetHost, basicAuth);
            forceBasicAuthContext.setAttribute(ClientContext.AUTH_CACHE, authCache);
        }
    }

    @Nullable
    @Override
    public <T> T execute(@Nonnull HttpRequest httpRequest, @Nonnull HttpResponseProcessor<T> responseProcessor) throws StashException {
        HttpRequestBase request = null;
        try {
            request = createRequest(httpRequest);
            request.addHeader("X-Atlassian-Token", "no-check"); // prevent XSRF checks

            final org.apache.http.HttpResponse response = httpClient.execute(request, httpRequest.isAnonymous() ? null : forceBasicAuthContext);

            final StatusLine status = response.getStatusLine();
            final Map<String, String> headers = toHeaderMultimap(response.getAllHeaders());
            final HttpEntity responseEntity = response.getEntity();
            final InputStream bodyStream = (null == responseEntity) ? new ByteArrayInputStream(new byte[0]) : responseEntity.getContent();
            final HttpResponse coreResponse = new HttpResponse(status.getStatusCode(), status.getReasonPhrase(), headers, bodyStream);
            return responseProcessor.process(coreResponse);

        } catch (IOException e) {
            throw new StashException(e);
        } finally {
            if (request != null) {
                request.reset();
            }
        }
    }

    private Map<String, String> toHeaderMultimap(Header[] headers) {
        Map<String, String> headerMap = Maps.newLinkedHashMap();

        for (Header header : headers) {
            String name = header.getName().toLowerCase();
            String existingValue = headerMap.get(name);
            headerMap.put(name, existingValue == null ? header.getValue() : existingValue + "," + header.getValue());
        }

        return ImmutableMap.copyOf(headerMap);
    }

    private HttpRequestBase createRequest(HttpRequest httpRequest) {
        URI fullUri = URI.create(baseUrl + "/" + httpRequest.getUrl()).normalize();
        final HttpEntityEnclosingRequestBase entityEnclosingRequest;
        switch (httpRequest.getMethod()) {
            case GET:
                return new HttpGet(fullUri);
            case DELETE:
                return new HttpDelete(fullUri);
            case POST:
                entityEnclosingRequest = new HttpPost(fullUri);
                break;
            case PUT:
                entityEnclosingRequest = new HttpPut(fullUri);
                break;
            default:
                throw new UnsupportedOperationException(String.format("http method %s is not supported", httpRequest.getMethod()));
        }

        final String payload = httpRequest.getPayload();
        if (payload != null) {
            entityEnclosingRequest.setEntity(new StringEntity(payload, APPLICATION_JSON));
        }
        return entityEnclosingRequest;
    }
}

*/

