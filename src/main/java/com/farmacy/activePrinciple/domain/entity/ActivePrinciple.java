package com.farmacy.activePrinciple.domain.entity;

public class ActivePrinciple {
    private long idAp;
    private String nameAp;

    public ActivePrinciple() {
    }

    public ActivePrinciple(long idAp, String nameAp) {
        this.idAp = idAp;
        this.nameAp = nameAp;
    }

    public long getIdAp() {
        return idAp;
    }

    public void setIdAp(long idAp) {
        this.idAp = idAp;
    }

    public String getNameAp() {
        return nameAp;
    }

    public void setNameAp(String nameAp) {
        this.nameAp = nameAp;
    }
}
