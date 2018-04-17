package com.atsistemas.c4.vcsprovisioning.test;

import com.atlassian.stash.rest.client.httpclient.HttpClientHttpExecutor;
import com.atsistemas.c4.vcsprovisioning.GroupProvisioner;

import java.net.MalformedURLException;
import java.net.URI;

import com.atlassian.stash.rest.client.httpclient.HttpClientConfig;

public class GroupTest {

	public static void main(String[] args) throws MalformedURLException {
		
		HttpClientConfig config = new HttpClientConfig(URI.create("http://localhost:7990").toURL(), "admin", "admin"); 
		HttpClientHttpExecutor executor = new HttpClientHttpExecutor(config);
		
		GroupProvisioner groupProvisioner = new GroupProvisioner(executor);
		
		groupProvisioner.addGroup("PruebaClaseGroup");

	}

}
