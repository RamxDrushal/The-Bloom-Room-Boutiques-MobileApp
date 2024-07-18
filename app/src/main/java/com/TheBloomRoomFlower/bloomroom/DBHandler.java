package com.TheBloomRoomFlower.bloomroom;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBHandler {
    private Context con;
    private DBConnector dbCon;
    private SQLiteDatabase db;

    public DBHandler(Context con) {
        this.con = con;
    }

    public void openDB() {
        this.dbCon = new DBConnector(con);
        this.db = dbCon.getWritableDatabase();
    }


    public User checkUser(User user) {
        try {
            //check whether any record with username=admin and password = 123
            Cursor cursor = db.rawQuery("select * from users where username='" + user.getUsername()
                    + "' and password='" + user.getPassword() + "'", null);

            if (cursor.moveToFirst()) {
                return user;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return user;
    }

    public User insertUser(User user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName", user.getFirstName());
        contentValues.put("lastName", user.getLastName());
        contentValues.put("username", user.getUsername());
        contentValues.put("contactNo", user.getContactNo());
        contentValues.put("email", user.getEmail());
        contentValues.put("password", user.getPassword());
        db.insert("users", null, contentValues);
        return user;
    }

    public Flower insertflower(Flower Flower) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("flowerNo", Flower.getflowerNo());
        contentValues.put("flowerName", Flower.getFlowersName());
        contentValues.put("quantity", Flower.getQuantity());
        contentValues.put("price", Flower.getPrice());
        db.insert("Flower", null, contentValues);
        return Flower;
    }

    public Category insertCategory(Category Category) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("catno", Category.getCatNo());
        contentValues.put("catname", Category.getCatName());
        contentValues.put("catinclude", Category.getCatInclude());
        contentValues.put("catquantity", Category.getCatQuantity());
        contentValues.put("catprice", Category.getCatPrice());
        db.insert("Category", null, contentValues);
        return Category;
    }

    public Cart addToCart(Cart crt) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("uname", crt.getUserN());
        contentValues.put("cname", crt.getFlowerName());
        contentValues.put("cqty", crt.getQty());
        db.insert("Cart", null, contentValues);
        return crt;
    }

    public List<Flower> getAllFlowerData() {
        List<Flower> dataList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Flower", null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Flower model = new Flower();
                model.setflowerName(cursor.getString(cursor.getColumnIndexOrThrow("flowerName")));
                model.setPrice(cursor.getString(cursor.getColumnIndexOrThrow("price")));

                dataList.add(model);
            } while (cursor.moveToNext());

        }
        return dataList;
    }

    public List<Category> getAllCategoryData() {
        List<Category> dataList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Category", null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Category model = new Category();
                model.setCatName(cursor.getString(cursor.getColumnIndexOrThrow("catname")));
                model.setCatInclude(cursor.getString(cursor.getColumnIndexOrThrow("catinclude")));
                model.setPrice(cursor.getString(cursor.getColumnIndexOrThrow("catprice")));

                dataList.add(model);
            } while (cursor.moveToNext());

        }
        return dataList;
    }

    public List<Cart> getAllCartData() {
        List<Cart> dataList = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Cart", null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Cart model = new Cart();
                model.setUserN(cursor.getString(cursor.getColumnIndexOrThrow("uname")));
                model.setfName(cursor.getString(cursor.getColumnIndexOrThrow("cname")));
                model.setQty(cursor.getString(cursor.getColumnIndexOrThrow("cqty")));

                dataList.add(model);
            } while (cursor.moveToNext());

        }
        return dataList;
    }

    public void deleteCartData(String username) {
        //SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Cart", "uname" + "=?", new String[]{username});
        db.close();
    }
}