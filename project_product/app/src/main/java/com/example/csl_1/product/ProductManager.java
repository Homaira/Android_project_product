package com.example.csl_1.product;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Faravy on 25-Jun-16.
 */
public class ProductManager {
    private Product product;
    private DatabaseHelper helper;
    private SQLiteDatabase database;

    public ProductManager(Context context) {
        helper = new DatabaseHelper(context);
    }

    private void open() {
        database = helper.getWritableDatabase();
    }

    private void close() {
        helper.close();
    }

    public boolean addProduct(Product product) {
        this.open();

        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COL_NAME, product.getName());
        cv.put(DatabaseHelper.COL_PRICE, product.getPrice());

        long inserted = database.insert(DatabaseHelper.PRODUCT_TABLE, null, cv);
        this.close();
        database.close();
        if (inserted > 0) {
            return true;
        } else return false;

    }

    public ArrayList<Product> getAllProduct() {
        this.open();
        ArrayList<Product> productList = new ArrayList<>();

        Cursor cursor = database.query(DatabaseHelper.PRODUCT_TABLE, null, null, null, null, null, null);
        cursor.moveToFirst();
        if (cursor != null && cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
                String phoneNo = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PRICE));

                Product product = new Product(id, name, phoneNo);
                productList.add(product);
                cursor.moveToNext();
            }
            this.close();
            database.close();

        }
        return productList;
    }


}
