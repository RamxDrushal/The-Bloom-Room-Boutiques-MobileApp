package com.TheBloomRoomFlower.bloomroom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnector extends SQLiteOpenHelper {
    DBConnector(Context con){
        super(con, "myapplication",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table users (firstName text,lastName text,username text,contactNo text,email text, password text)");

        sqLiteDatabase.execSQL("create table Flower (flowerno text,flowerName text,quantity text,price text)");

        sqLiteDatabase.execSQL("create table Category (catno text,catname text,catinclude text, catquantity text,catprice text)");
        //sqLiteDatabase.execSQL("create table Cart (uname text,cname text,cqty text)");
        sqLiteDatabase.execSQL("create table Cart (cqty text,cname text,uname text)");

        ContentValues contentValues1 = new ContentValues();
        contentValues1.put("firstName", "Admin");
        contentValues1.put("lastName", "Admin");
        contentValues1.put("username", "Admin");
        contentValues1.put("contactNo", "0745455454");
        contentValues1.put("email", "admin@gmail.com");
        contentValues1.put("password", "admin123");

        sqLiteDatabase.insert("users", null, contentValues1);

        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName", "Sam");
        contentValues.put("lastName", "Peters");
        contentValues.put("username", "SamP");
        contentValues.put("contactNo", "0745455454");
        contentValues.put("email", "sam@gmail.com");
        contentValues.put("password", "Sam123!");

        sqLiteDatabase.insert("users", null, contentValues);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDb = this.getWritableDatabase();
        Cursor cursor = MyDb.rawQuery("select * from users where username= ? and password= ?", new String[]{username, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }

}