package com.atsistemas.c4.vcsprovisioning;

import com.atlassian.stash.rest.client.core.http.UriBuilder;
import static com.atlassian.stash.rest.client.core.http.HttpMethod.POST;

import com.atlassian.stash.rest.client.core.StashClientImpl;
import com.atlassian.stash.rest.client.core.http.HttpExecutor;

import com.atlassian.stash.rest.client.api.StashRestException;

public class GroupProvisioner extends StashClientImpl {
	
	public static final int GROUP_ARREADY_EXISTS = 409;
	public static final int GROUP_CREATED = 200;
	public static final int ADMIN_PRIVILEGES_REQUIRED = 401;
	public static final int MALFORMED_REQUEST = 400;


	public GroupProvisioner(HttpExecutor httpExecutor) {
		
		super(httpExecutor);

	}

	public void addGroup(String groupName) throws Exception{
		
            UriBuilder uriBuilder = UriBuilder.forPath("/rest/api/1.0/admin/groups")
            		.addQueryParam("name", groupName);
            try {
            	
            	super.doRestCall(uriBuilder, POST, null, false);

            	
            } catch (StashRestException e) {
            	
                int status = e.getStatusCode();
                
                switch (status) {
                
                	case GROUP_ARREADY_EXISTS:
                		break;
                	case ADMIN_PRIVILEGES_REQUIRED: 
                		throw new Exception("Admin Privileges required for this operation");
                	case MALFORMED_REQUEST:
                		throw new Exception("Malformed request");
                	case GROUP_CREATED:
                		break;
                	default:
                		throw new Exception("Unknown Error");
                }
            	
            }
        }
	
}
