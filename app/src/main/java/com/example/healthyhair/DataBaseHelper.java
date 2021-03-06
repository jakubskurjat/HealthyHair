package com.example.healthyhair;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String PRODUCTS_ADDED = "PRODUCT_ADDED";
    public static final String COLUMN_ID = "COLUMN_ID";
    private static final String COLUMN_DATE = "COLUMN_DATE";
    public static final String COLUMN_NAME = "COLUMN_NAME";
    public static final String COLUMN_COMPOSITION = "COLUMN_COMPOSITION";
    public static final String COLUMN_PRODUCT_TYPE = "COLUMN_PRODUCT_TYPE";
    public static final String COLUMN_TYPE = "COLUMN_TYPE";
    public static final String COLUMN_POROSITY = "COLUMN_POROSITY";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "products.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createStatement = "CREATE TABLE " + PRODUCTS_ADDED + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DATE + " TEXT, " + COLUMN_NAME + " TEXT, " + COLUMN_COMPOSITION + " TEXT, " +
                COLUMN_PRODUCT_TYPE + " TEXT, " + COLUMN_TYPE + " TEXT, " + COLUMN_POROSITY + " TEXT)";

        db.execSQL(createStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DATE, product.getTime());
        cv.put(COLUMN_NAME, product.getName());
        cv.put(COLUMN_COMPOSITION, product.getComposition());
        cv.put(COLUMN_PRODUCT_TYPE, product.getProductType());
        cv.put(COLUMN_TYPE, product.getType());
        cv.put(COLUMN_POROSITY, product.getPorosity());

        long insert = db.insert(PRODUCTS_ADDED, null, cv);

        if (insert < 0) {
            return false;
        } else {
            return true;
        }
    }


    public List<Product> getProducts() {
        List<Product> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + PRODUCTS_ADDED;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                String date = cursor.getString(1);
                String name = cursor.getString(2);
                String composition = cursor.getString(3);
                String productType = cursor.getString(4);
                String type = cursor.getString(5);
                String porosity = cursor.getString(6);

                Product product = new Product(date, name, composition, productType, type, porosity);
                returnList.add(product);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return returnList;
    }
}
