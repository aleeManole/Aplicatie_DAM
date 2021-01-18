package com.example.aplicatieshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String USER = "User";
    public static final String ID = "id";
    public static final String ID_USER = ID + "_user";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String ID_PRODUCT = ID + "_product";
    public static final String PRODUCT = "Product";
    public static final String NAME = "name";
    public static final String DETAILS = "details";
    public static final String PRICE = "price";
    public static final String IMAGE = "image";
    public static final String QUANTITY = "quantity";
    public static final String ORDER = "Order";
    public static final String ID_ORDER = ID + "_order";
    public static final String DATE = "DATE";
    public static final String ORDER_PRODUCT = "Order_Product";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "ShopApplication.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        SQLiteStatement sqLiteStatementUser= SqlHelper.getUserCreateTableStm(db, USER, ID_USER, USERNAME, PASSWORD);
        sqLiteStatementUser.execute();

        SQLiteStatement sqLiteStatementProduct= SqlHelper.getProductCreateTableStm(db, PRODUCT, ID_PRODUCT, NAME, DETAILS, PRICE, IMAGE, QUANTITY);
        sqLiteStatementProduct.execute();

        SQLiteStatement sqLiteStatementOrder= SqlHelper.getOrderCreateTableStm(db, ORDER, USER, ID_ORDER, DATE, ID_USER);
        sqLiteStatementOrder.execute();

        SQLiteStatement sqLiteStatementOrderProduct = SqlHelper.getOrderProductCreateTableStm(db, ORDER_PRODUCT, ORDER, PRODUCT, ID_ORDER, ID_PRODUCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addUser(UserModel userModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(USERNAME, userModel.getUsername());
        cv.put(PASSWORD, userModel.getPassword());

        long insert = db.insert(USER, null, cv);
        if (insert == 1) {
            return false;
        } else {

            return true;
        }
    }

    public List<UserModel> selectAll(){
        List<UserModel> returnList = new ArrayList<>();
        //get data from db
        String queryString="SELECT * FROM " + USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            do{
                int userId= cursor.getInt(0);
                String username= cursor.getString(1);
                String password= cursor.getString(2);

                UserModel newUser=  new UserModel(userId, username, password);
                returnList.add(newUser);

            }while (cursor.moveToNext());
        }
        else{
            //when does not add anything to the list
        }
        cursor.close();
        db.close();
        return returnList;
    }
}
