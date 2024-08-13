package com.farmacy.modeAdministration.domain.entitiy;

public class ModeAdministration {
    private Long id;
    private String descriptionMode;

    
    public ModeAdministration() {
    }

    public ModeAdministration(Long id, String descriptionMode) {
        this.id = id;
        this.descriptionMode = descriptionMode;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescriptionMode() {
        return descriptionMode;
    }
    public void setDescriptionMode(String descriptionMode) {
        this.descriptionMode = descriptionMode;
    }
    
    
}
