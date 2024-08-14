package com.farmacy.customer.domain.entity;

public class Customer {
    private String idCustomer;
    private String nameCustomer;
    private String lastNameCustomer;
    private String codeCityCustomer;
    private String emailCustomer;
    private java.sql.Date birthDate;
    private double lon;
    private double latitud;

    // Constructors, Getters, Setters, and toString() method
    public Customer() {}

    public Customer(String idCustomer, String nameCustomer, String lastNameCustomer, String codeCityCustomer,
                    String emailCustomer, java.sql.Date birthDate, double lon, double latitud) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.lastNameCustomer = lastNameCustomer;
        this.codeCityCustomer = codeCityCustomer;
        this.emailCustomer = emailCustomer;
        this.birthDate = birthDate;
        this.lon = lon;
        this.latitud = latitud;
    }

    public String getIdCustomer() { 
        return idCustomer; 
    }

    public void setIdCustomer(String idCustomer) { 
        this.idCustomer = idCustomer; 
    }

    public String getNameCustomer() { 
        return nameCustomer; 
    }

    public void setNameCustomer(String nameCustomer) { 
        this.nameCustomer = nameCustomer; 
    }

    public String getLastNameCustomer() { 
        return lastNameCustomer; 
    }

    public void setLastNameCustomer(String lastNameCustomer) { 
        this.lastNameCustomer = lastNameCustomer; 
    }

    public String getCodeCityCustomer() { 
        return codeCityCustomer; 
    }
    
    public void setCodeCityCustomer(String codeCityCustomer) { 
        this.codeCityCustomer = codeCityCustomer; 
    }

    public String getEmailCustomer() { 
        return emailCustomer; 
    }

    public void setEmailCustomer(String emailCustomer) { 
        this.emailCustomer = emailCustomer; 
    }

    public java.sql.Date getBirthDate() { 
        return birthDate; 
    }

    public void setBirthDate(java.sql.Date birthDate) { 
        this.birthDate = birthDate; 
    }

    public double getLon() { 
        return lon; 
    }

    public void setLon(double lon) { 
        this.lon = lon; 
    }

    public double getLatitud() { 
        return latitud; 
    }

    public void setLatitud(double latitud) { 
        this.latitud = latitud; 
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer='" + idCustomer + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", lastNameCustomer='" + lastNameCustomer + '\'' +
                ", codeCityCustomer='" + codeCityCustomer + '\'' +
                ", emailCustomer='" + emailCustomer + '\'' +
                ", birthDate=" + birthDate +
                ", lon=" + lon +
                ", latitud=" + latitud +
                '}';
    }
}
