package com.example.takeawaypro.bean;

public class Cart {

    private int user_id;
    private String cookingpin_name;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCookingpin_name() {
        return cookingpin_name;
    }

    public void setCookingpin_name(String cookingpin_name) {
        this.cookingpin_name = cookingpin_name;
    }

    public int getCookingpin_id() {
        return cookingpin_id;
    }

    public void setCookingpin_id(int cookingpin_id) {
        this.cookingpin_id = cookingpin_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCooking_number() {
        return cooking_number;
    }

    public void setCooking_number(int cooking_number) {
        this.cooking_number = cooking_number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    private int cookingpin_id;
    private float price;
    private int cooking_number;
    private String picture;
    private String introduce;
}
