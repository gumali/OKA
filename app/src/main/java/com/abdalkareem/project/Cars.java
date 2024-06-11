package com.abdalkareem.project;


public class Cars {
    private String carImage ;
    private int ID;
    private int model;
    private String licinse ;
    private String name;
    private String company;


    public Cars(String carImage, int ID, int model, String licinse, String name, String company) {
        this.carImage = carImage;
        this.ID = ID;
        this.model = model;
        this.licinse = licinse;
        this.name = name;
        this.company = company;
    }

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getLicinse() {
        return licinse;
    }

    public void setLicinse(String licinse) {
        this.licinse = licinse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }




}

