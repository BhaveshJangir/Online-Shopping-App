package com.example.onlineshopping;

public class Item {
    public String brand,name,price;
    public int mImageResourceId = no_provided_image;
    public static final int no_provided_image = -1;

    @Override
    public String toString() {
        return "Item{" +
                "brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }

    public Item(String brand, String name, String price) {
        this.brand = brand;
        this.name = name;
        this.price = price;
    }

    public Item(String brand, String name, String price, int mImageResourceId) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.mImageResourceId = mImageResourceId;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public void setmImageResourceId(int mImageResourseId) {
        this.mImageResourceId = mImageResourseId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public  boolean hasImage(){
        return mImageResourceId != no_provided_image;
    }
}
