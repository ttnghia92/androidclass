package com.example.day2;

public class Product {
    private String name;
    private String prive;
    private int imgage;

    public Product() {
    }

    public Product(String name, String prive, int imgage) {
        this.name = name;
        this.prive = prive;
        this.imgage = imgage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrive() {
        return prive;
    }

    public void setPrive(String prive) {
        this.prive = prive;
    }

    public int getImgage() {
        return imgage;
    }

    public void setImgage(int imgage) {
        this.imgage = imgage;
    }
}
