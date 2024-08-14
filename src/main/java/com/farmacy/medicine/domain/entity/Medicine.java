package com.farmacy.medicine.domain.entity;

public class Medicine {
    private int id;
    private String proceedings;
    private String nameMedicine;
    private String healthRegister;
    private String descriptionLong;
    private String descriptionShort;
    private int codeModeAdmin;
    private int codeAp;
    private int codeUm;
    private String nameRol;
    private int codeLab;

    public Medicine() {}

    public Medicine(int id, String proceedings, String nameMedicine, String healthRegister, String descriptionLong, String descriptionShort,
                    int codeModeAdmin, int codeAp, int codeUm, String nameRol, int codeLab) {
        this.id = id;
        this.proceedings = proceedings;
        this.nameMedicine = nameMedicine;
        this.healthRegister = healthRegister;
        this.descriptionLong = descriptionLong;
        this.descriptionShort = descriptionShort;
        this.codeModeAdmin = codeModeAdmin;
        this.codeAp = codeAp;
        this.codeUm = codeUm;
        this.nameRol = nameRol;
        this.codeLab = codeLab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProceedings() {
        return proceedings;
    }

    public void setProceedings(String proceedings) {
        this.proceedings = proceedings;
    }

    public String getNameMedicine() {
        return nameMedicine;
    }

    public void setNameMedicine(String nameMedicine) {
        this.nameMedicine = nameMedicine;
    }

    public String getHealthRegister() {
        return healthRegister;
    }

    public void setHealthRegister(String healthRegister) {
        this.healthRegister = healthRegister;
    }

    public String getDescriptionLong() {
        return descriptionLong;
    }

    public void setDescriptionLong(String descriptionLong) {
        this.descriptionLong = descriptionLong;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public int getCodeModeAdmin() {
        return codeModeAdmin;
    }

    public void setCodeModeAdmin(int codeModeAdmin) {
        this.codeModeAdmin = codeModeAdmin;
    }

    public int getCodeAp() {
        return codeAp;
    }

    public void setCodeAp(int codeAp) {
        this.codeAp = codeAp;
    }

    public int getCodeUm() {
        return codeUm;
    }

    public void setCodeUm(int codeUm) {
        this.codeUm = codeUm;
    }

    public String getNameRol() {
        return nameRol;
    }

    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }

    public int getCodeLab() {
        return codeLab;
    }

    public void setCodeLab(int codeLab) {
        this.codeLab = codeLab;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", proceedings='" + proceedings + '\'' +
                ", nameMedicine='" + nameMedicine + '\'' +
                ", healthRegister='" + healthRegister + '\'' +
                ", descriptionLong='" + descriptionLong + '\'' +
                ", descriptionShort='" + descriptionShort + '\'' +
                ", codeModeAdmin=" + codeModeAdmin +
                ", codeAp=" + codeAp +
                ", codeUm=" + codeUm +
                ", nameRol='" + nameRol + '\'' +
                ", codeLab=" + codeLab +
                '}';
    }
}
