package com.farmacy.country.domain.entity;

public class Country {
    private String codeCountry;
    private String nameCountry;

    // Constructor vacío
    public Country() {}

    // Constructor con parámetros
    public Country(String codeCountry, String nameCountry) {
        this.codeCountry = codeCountry;
        this.nameCountry = nameCountry;
    }

    // Getters y setters
    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(String codeCountry) {
        this.codeCountry = codeCountry;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    @Override
    public String toString() {
        return "Country{" +
                "codeCountry='" + codeCountry + '\'' +
                ", nameCountry='" + nameCountry + '\'' +
                '}';
    }
}
