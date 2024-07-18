package com.TheBloomRoomFlower.bloomroom;

public class Flower {

    private String flowerNo;
    private String flowerName;
    private String price;
    private String quantity;


    // Constructor with four parameters
    public Flower(String flowerNo, String flowerName, String price, String quantity) {
        this.flowerNo = flowerNo;
        this.flowerName = flowerName;
        this.price = price;
        this.quantity = quantity;
    }

    // Additional constructor with two parameters
    public Flower(String id, String price) {
        // Assign parameters to corresponding fields
        this.flowerNo = id;
        this.price = price;
    }

    // Default constructor
    public Flower() {
    }

    public String getFlowersName() {
        return flowerName;
    }

    public String getflowerNo() {
        return flowerNo;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setFlowerNo(String flowerNo) {
        this.flowerNo = flowerNo;
    }

    public void setflowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}



