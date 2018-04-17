package com.atsistemas.c4.vcsprovision.entity;


public class ProvisionData {

    private String vcsURI;

    private String vcsUser;

    private String vcsPass;

    private VCSProject project; 

    private VCSRepository repository;

    private VCSGroup group;

    private VCSWebhook webhook;

    private enum cvsName  {
        BITBUCKET;
    }


    /**
     * Container of the provision data to be used into the provisioning process
     * @param vcsURI URI where the Version Control System is attending requests
     * @param vcsUser Administrative user of the Version Control System
     * @param vcsPass Password for the administrative user of the Version Control System
     */
    public void ProvisionData (String vcsUri, String vcsUser, String vcsPass) {

        this.vcsURI = vcsUri;
        this.vcsUser = vcsUser;
        this.vcsPass = vcsPass;

    }

    public VCSProject getProject() {
        return project;
    }

    public VCSRepository getRepository() {
        return repository;
    }

    public VCSGroup getGroup() {
        return group;
    }

    public VCSWebhook getWebhook() {
        return webhook;
    }

    public void setProject(VCSProject project) {
        this.project = project;
    }

    public void setRepository(VCSRepository repository) {
        this.repository = repository;
    }

    public void setGroup(VCSGroup group) {
        this.group = group;
    }

    public void setWebhook(VCSWebhook webhook) {
        this.webhook = webhook;
    }

    public String getVcsURI() {
        return vcsURI;
    }

    public String getVcsUser() {
        return vcsUser;
    }

    public String getVcsPass() {
        return vcsPass;
    }
}
