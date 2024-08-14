package com.farmacy.labatory.domain.entity;

public class Labatory {
    private int id;
    private String nameLab;
    private String codeCityReg;

    public Labatory() {}

    public Labatory(int id, String nameLab, String codeCityReg) {
        this.id = id;
        this.nameLab = nameLab;
        this.codeCityReg = codeCityReg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameLab() {
        return nameLab;
    }

    public void setNameLab(String nameLab) {
        this.nameLab = nameLab;
    }

    public String getCodeCityReg() {
        return codeCityReg;
    }

    public void setCodeCityReg(String codeCityReg) {
        this.codeCityReg = codeCityReg;
    }

    @Override
    public String toString() {
        return "Labatory{" +
                "id=" + id +
                ", nameLab='" + nameLab + '\'' +
                ", codeCityReg='" + codeCityReg + '\'' +
                '}';
    }
}
