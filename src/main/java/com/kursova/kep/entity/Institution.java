package com.kursova.kep.entity;

import java.util.List;

public class Institution extends BaseWithName{

    private String phone;
    private Integer ratingInterior;
    private Integer ratingService;
    private Integer ratingKitchen;
    private String supplements;
    private List<Menu> menuSet;


    public Institution() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRatingInterior() {
        return ratingInterior;
    }

    public void setRatingInterior(Integer ratingInterior) {
        this.ratingInterior = ratingInterior;
    }

    public Integer getRatingService() {
        return ratingService;
    }

    public void setRatingService(Integer ratingService) {
        this.ratingService = ratingService;
    }

    public Integer getRatingKitchen() {
        return ratingKitchen;
    }

    public void setRatingKitchen(Integer ratingKitchen) {
        this.ratingKitchen = ratingKitchen;
    }

    public String getSupplements() {
        return supplements;
    }

    public void setSupplements(String supplements) {
        this.supplements = supplements;
    }

    public List<Menu> getMenuSet() {
        return menuSet;
    }

    public void setMenuSet(List<Menu> menuSet) {
        this.menuSet = menuSet;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "supplements='" + supplements + '\'' +
                ", ratingKitchen=" + ratingKitchen +
                ", ratingService=" + ratingService +
                ", ratingInterior=" + ratingInterior +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
