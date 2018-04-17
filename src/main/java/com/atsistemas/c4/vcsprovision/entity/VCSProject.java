package com.atsistemas.c4.vcsprovision.entity;

public class VCSProject {
	
	public VCSProject () {
		
	}

    private String key;

    private String name;

    private String description;

    private boolean isPrivate;

    private String type;

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public String getType() {
        return type;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public void setType(String type) {
        this.type = type;
    }
}
