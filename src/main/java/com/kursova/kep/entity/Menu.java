package com.kursova.kep.entity;

public class Menu extends BaseEntity{

    private String nameOfKitchen;
    private String nameOfSnack;
    private String storage;
    private Double weight;
    private Double coast;

    public Menu() {
    }

    public String getNameOfKitchen() {
        return nameOfKitchen;
    }

    public void setNameOfKitchen(String nameOfKitchen) {
        this.nameOfKitchen = nameOfKitchen;
    }

    public String getNameOfSnack() {
        return nameOfSnack;
    }

    public void setNameOfSnack(String nameOfSnack) {
        this.nameOfSnack = nameOfSnack;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getCoast() {
        return coast;
    }

    public void setCoast(Double coast) {
        this.coast = coast;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", nameOfKitchen='" + nameOfKitchen + '\'' +
                ", nameOfSnack='" + nameOfSnack + '\'' +
                ", storage='" + storage + '\'' +
                ", weight=" + weight +
                ", coast=" + coast +
                '}';
    }
}
