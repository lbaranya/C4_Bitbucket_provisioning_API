package com.atsistemas.c4.vcsprovisioning;

import com.atlassian.stash.rest.client.httpclient.HttpClientConfig;

import com.atsistemas.c4.vcsprovision.entity.ProvisionData;


public class ProvisionManager {

    private ProvisionData data;

    private HttpClientConfig httpConfig;

    public ProvisionManager (ProvisionData data) {

        this.data = data;

    }


}
