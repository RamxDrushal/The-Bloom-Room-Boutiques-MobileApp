package com.TheBloomRoomFlower.bloomroom;

public class Cart {

    public Cart(String userN, String flowerName, String qty) {
        this.userN = userN;
        this.flowerName = flowerName;
        this.qty = qty;
    }

    public Cart() {

    }

    public String getUserN() {
        return userN;
    }

    public void setUserN(String userN) {
        this.userN = userN;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setfName(String flowerName) {
        this.flowerName = flowerName;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    private String userN;
    private String flowerName;
    private String qty;
}

