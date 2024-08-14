package com.farmacy.unitMeasurement.domain.entity;

public class UnitMeasurement {

    private long idUm;
    private String nameUm;

    public UnitMeasurement() {
    }

    public UnitMeasurement(long idUm, String nameUm) {
        this.idUm = idUm;
        this.nameUm = nameUm;
    }

    public long getIdUm() {
        return idUm;
    }

    public void setIdUm(long idUm) {
        this.idUm = idUm;
    }

    public String getNameUm() {
        return nameUm;
    }

    public void setNameUm(String nameUm) {
        this.nameUm = nameUm;
    }
}
    