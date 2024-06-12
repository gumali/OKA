package com.abdalkareem.project;


public class Brand {
    private int ID;
    private String image;
    private int IDClassification;

    public Brand(int ID, String image, int clas) {
        this.ID = ID;
        this.image = image;
        this.IDClassification = clas;
    }

    public int getID() {
        return ID;
    }



    public String getImage() {
        return image;
    }



    public int getIDClassification() {
        return IDClassification;
    }



    public void setId(int id) {
        this.ID = id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setIDClassification(int IDClassification) {
        this.IDClassification = IDClassification;
    }
}
