package com.atsistemas.c4.vcsprovisioning;


import com.atlassian.stash.rest.client.core.http.UriBuilder;
import static com.atlassian.stash.rest.client.core.http.HttpMethod.GET;
import static com.atlassian.stash.rest.client.core.http.HttpMethod.POST;

import com.atlassian.stash.rest.client.core.StashClientImpl;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.atlassian.stash.rest.client.core.http.HttpExecutor;
import com.atlassian.stash.rest.client.core.http.HttpMethod;
import com.atlassian.stash.rest.client.httpclient.HttpClientHttpExecutor;
import com.atlassian.stash.rest.client.httpclient.HttpClientConfig;
import com.atlassian.stash.rest.client.api.StashRestException;

public class GroupProvisioner extends StashClientImpl {


	public GroupProvisioner(HttpExecutor httpExecutor) {
		
		super(httpExecutor);

	}

	public void addGroup(String groupName) {
		
            UriBuilder uriBuilder = UriBuilder.forPath("/rest/api/1.0/admin/groups")
            		.addQueryParam("name", groupName);
            System.out.println("uriBuilder: " + uriBuilder);
            try {
            	
            	super.doRestCall(uriBuilder, POST, null, false);

            	
            } catch (StashRestException e) {
            	
            	//TODO cambiar manejo excepción	
                System.out.println("el código del error" + e.getStatusCode());
                throw e;
            	
            }
        }
	
	
	public boolean groupExists (String groupName) {
		
		
		
		
		//Cambiar el retorno del método
		return true;
		
	}
	
}
