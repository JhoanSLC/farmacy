package com.farmacy.modeAdministration.domain.entitiy;

public class ModeAdministration {
    private long id;
    private String descriptionMode;

    
    public ModeAdministration() {
    }

    public ModeAdministration(long id, String descriptionMode) {
        this.id = id;
        this.descriptionMode = descriptionMode;
    }


    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getDescriptionMode() {
        return descriptionMode;
    }
    public void setDescriptionMode(String descriptionMode) {
        this.descriptionMode = descriptionMode;
    }
    
    
}
