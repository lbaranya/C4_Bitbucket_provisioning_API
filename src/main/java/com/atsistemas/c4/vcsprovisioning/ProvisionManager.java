package com.atsistemas.c4.vcsprovisioning;

import com.atlassian.stash.rest.client.httpclient.HttpClientConfig;

import com.atsistemas.c4.vcsprovision.entity.ProvisionData;
import com.google.gson.JsonObject;


public class ProvisionManager {

    private JsonObject json;

    private HttpClientConfig httpConfig;
    
    private ProvisionData data;
    

    public ProvisionManager (JsonObject json) {

        this.json = json;
        data = null;

    }
    
    public void doProvision () throws Exception {
    	
    	try {
    		
    		this.parseJsonFile();
    		
    	} catch (Exception e) {
    		
    		//TODO cambiar el manejo de excepcion
    		System.out.println("ko por: " + e);
    		throw e;
    	}
    	    		
		this.doGroupProvision();
		this.doProjectProvision();
		this.doRepositoryProvision();
		this.doWebHookProvision();    		
    	
    }
    
    private void doProjectProvision() {
    	
    	ProjectProvisioner provisioner = new ProjectProvisioner();
    	
    	
    }
    
    private void doRepositoryProvision () {
    	
    	
    }
    
    private void doGroupProvision () {
    	
    	
    }
    
    private void doWebHookProvision () {
    	
    	
    }
    
    private void parseJsonFile () {
    	
    	
    } 
    


}
