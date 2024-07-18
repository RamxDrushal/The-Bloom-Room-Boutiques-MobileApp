package com.TheBloomRoomFlower.bloomroom;

public class Category {


    public Category(String catNo, String catName, String catInclude, String catPrice, String catQuantity) {
        this.catNo = catNo;
        this.catInclude = catInclude;
        this.catName = catName;
        this.catPrice = catPrice;
        this.catQuantity = catQuantity;
    }
    private String catNo;
    private String catName;
    private String catPrice;
    private String catQuantity;
    private String catInclude;

    public String getCatInclude() {
        return catInclude;
    }
    public Category(){}
    public void setCatInclude(String catInclude) {
        this.catInclude = catInclude;
    }

    public String getCatName() {return catName;}
    public String getCatNo() {return catNo;}

    public String getCatPrice() {
        return catPrice;
    }

    public String getCatQuantity() {
        return catQuantity;
    }

    public void setCatNo(String catNo) {
        this.catNo = catNo;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public void setPrice(String catPrice) {this.catPrice = catPrice;}

    public void setCatQuantity(String catQuantity) {this.catQuantity = catQuantity;}

}
