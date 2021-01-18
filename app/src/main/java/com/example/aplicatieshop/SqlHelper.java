package com.example.aplicatieshop;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class SqlHelper {

    public static SQLiteStatement getUserCreateTableStm(SQLiteDatabase db, String USER, String ID_USER, String USERNAME, String PASSWORD) {
        String str = "CREATE TABLE " + USER + "(" + ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USERNAME + " TEXT, " + PASSWORD + " TEXT)";

        SQLiteStatement sqLiteStatement = db.compileStatement(str);
        return sqLiteStatement;
    }

    public static SQLiteStatement getProductCreateTableStm(SQLiteDatabase db, String PRODUCT, String ID_PRODUCT, String NAME, String DETAILS, String PRICE, String IMAGE, String QUANTITY) {
        String str = "CREATE TABLE" + PRODUCT + "(" + ID_PRODUCT + "INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + "TEXT," + DETAILS + "TEXT," + PRICE + "INTEGER," + IMAGE + "TEXT," + QUANTITY + "INTEGER)";

        SQLiteStatement sqLiteStatement = db.compileStatement(str);
        return sqLiteStatement;
    }

    public static SQLiteStatement getOrderCreateTableStm(SQLiteDatabase db, String ORDER, String USER, String ID_ORDER, String DATE, String ID_USER) {

        String str = "CREATE TABLE " + ORDER + " ( " + ID_ORDER + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DATE + "TEXT," + ID_USER + "INTEGER, FOREIGN KEY(" + ID_USER + ") REFERENCES " + USER + "(" + ID_USER + "))";

        SQLiteStatement sqLiteStatement = db.compileStatement(str);
        return sqLiteStatement;
    }

    public static SQLiteStatement getOrderProductCreateTableStm(SQLiteDatabase db, String ORDER_PRODUCT, String ORDER, String PRODUCT, String ID_ORDER, String ID_PRODUCT) {
        String str = "CREATE TABLE " + ORDER_PRODUCT + "(" + ID_ORDER + "INTEGER, FOREIGN KEY(" + ID_ORDER + ") REFERENCES " + ORDER + "(" + ID_ORDER + "), FOREIGN KEY(" + ID_PRODUCT +") REFERENCES " + PRODUCT + "(" + ID_PRODUCT +"))";

        SQLiteStatement sqLiteStatement = db.compileStatement(str);
        return sqLiteStatement;
    }


}
