package com.farmacy.farmacyMedicine.domain.entity;

public class FarmacyMedicine {
    private int idFarmacyMedicine;
    private int idFarmacy;
    private int idMedicineFatrm;
    private double price;

    public FarmacyMedicine() {}

    public FarmacyMedicine(int idFarmacyMedicine, int idFarmacy, int idMedicineFatrm, double price) {
        this.idFarmacyMedicine = idFarmacyMedicine;
        this.idFarmacy = idFarmacy;
        this.idMedicineFatrm = idMedicineFatrm;
        this.price = price;
    }

    public int getIdFarmacyMedicine() {
        return idFarmacyMedicine;
    }

    public void setIdFarmacyMedicine(int idFarmacyMedicine) {
        this.idFarmacyMedicine = idFarmacyMedicine;
    }

    public int getIdFarmacy() {
        return idFarmacy;
    }

    public void setIdFarmacy(int idFarmacy) {
        this.idFarmacy = idFarmacy;
    }

    public int getIdMedicineFatrm() {
        return idMedicineFatrm;
    }

    public void setIdMedicineFatrm(int idMedicineFatrm) {
        this.idMedicineFatrm = idMedicineFatrm;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FarmacyMedicine{" +
                "idFarmacyMedicine=" + idFarmacyMedicine +
                ", idFarmacy=" + idFarmacy +
                ", idMedicineFatrm=" + idMedicineFatrm +
                ", price=" + price +
                '}';
    }
}
