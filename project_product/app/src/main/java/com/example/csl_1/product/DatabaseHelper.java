package com.example.csl_1.product;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Faravy on 25-Jun-16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "products_db";
    public static final int DATAVBASE_VERSION = 1;
    public static final String PRODUCT_TABLE = "products";

    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_PRICE = "price";


    private static final String CREATE_CONTACT_TABLE=" CREATE TABLE "+ PRODUCT_TABLE +
            "( "+ COL_ID +" INTEGER PRIMARY KEY,"+ COL_NAME +" TEXT,"+COL_PRICE
            +" TEXT )";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATAVBASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_CONTACT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
