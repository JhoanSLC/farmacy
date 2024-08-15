package com.farmacy.farmacy.domain.entity;

public class Farmacy {
    private int idFarmacy;
    private String nameFarmacy;
    private String addressFarmacy;
    private double lonFarmacy;
    private double latFarmacy;
    private String codeCityFarm;
    private String logoFarmacy;

    public Farmacy() {}

    public Farmacy(int idFarmacy, String nameFarmacy, String addressFarmacy, double lonFarmacy, double latFarmacy, String codeCityFarm, String logoFarmacy) {
        this.idFarmacy = idFarmacy;
        this.nameFarmacy = nameFarmacy;
        this.addressFarmacy = addressFarmacy;
        this.lonFarmacy = lonFarmacy;
        this.latFarmacy = latFarmacy;
        this.codeCityFarm = codeCityFarm;
        this.logoFarmacy = logoFarmacy;
    }

    public int getIdFarmacy() {
        return idFarmacy;
    }

    public void setIdFarmacy(int idFarmacy) {
        this.idFarmacy = idFarmacy;
    }

    public String getNameFarmacy() {
        return nameFarmacy;
    }

    public void setNameFarmacy(String nameFarmacy) {
        this.nameFarmacy = nameFarmacy;
    }

    public String getAddressFarmacy() {
        return addressFarmacy;
    }

    public void setAddressFarmacy(String addressFarmacy) {
        this.addressFarmacy = addressFarmacy;
    }

    public double getLonFarmacy() {
        return lonFarmacy;
    }

    public void setLonFarmacy(double lonFarmacy) {
        this.lonFarmacy = lonFarmacy;
    }

    public double getLatFarmacy() {
        return latFarmacy;
    }

    public void setLatFarmacy(double latFarmacy) {
        this.latFarmacy = latFarmacy;
    }

    public String getCodeCityFarm() {
        return codeCityFarm;
    }

    public void setCodeCityFarm(String codeCityFarm) {
        this.codeCityFarm = codeCityFarm;
    }

    public String getLogoFarmacy() {
        return logoFarmacy;
    }

    public void setLogoFarmacy(String logoFarmacy) {
        this.logoFarmacy = logoFarmacy;
    }

    @Override
    public String toString() {
        return "Farmacy{" +
                "idFarmacy=" + idFarmacy +
                ", nameFarmacy='" + nameFarmacy + '\'' +
                ", addressFarmacy='" + addressFarmacy + '\'' +
                ", lonFarmacy=" + lonFarmacy +
                ", latFarmacy=" + latFarmacy +
                ", codeCityFarm='" + codeCityFarm + '\'' +
                ", logoFarmacy='" + logoFarmacy + '\'' +
                '}';
    }
}
