package com.acenovator.moneymanager.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.acenovator.moneymanager.models.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nimzy on 1/19/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "MoneyManager";

    // Table Names
    private static final String TABLE_CAT = "categories";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";

    // Categories Table columns
    private static final String KEY_NAME = "name";
    private static final String KEY_TYPE = "type";

    // Table Create Statements
    // Categories table create statement
    private static final String CREATE_TABLE_CAT = "CREATE TABLE "
            + TABLE_CAT + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_TYPE + " TEXT," + KEY_CREATED_AT
            + " DATETIME" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_CAT);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CAT);

        // create new tables
        onCreate(db);
    }

    // Adding new category
    public void addCategory(Category category) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, category.getName()); // Category Name
        values.put(KEY_TYPE, category.getType()); // Category Type

        // Inserting Row
        db.insert(TABLE_CAT, null, values);
        db.close(); // Closing database connection
    }

    // Getting single category
    public Category getCategory(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CAT, new String[] { KEY_ID,
                        KEY_NAME, KEY_TYPE }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Category contact = new Category(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return category
        return contact;
    }

    // Getting All Categories
    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<Category>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CAT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Category category = new Category();
                category.setID(Integer.parseInt(cursor.getString(0)));
                category.setName(cursor.getString(1));
                category.setType(cursor.getString(2));
                // Adding contact to list
                categoryList.add(category);
            } while (cursor.moveToNext());
        }

        // return category list
        return categoryList;
    }

    // Getting category Count
    public int getCategoriesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CAT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // Updating single category
    public int updateCategory(Category category) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, category.getName());
        values.put(KEY_TYPE, category.getType());

        // updating row
        return db.update(TABLE_CAT, values, KEY_ID + " = ?",
                new String[]{String.valueOf(category.getID())});
    }

    // Deleting single category
    public void deleteCategory(Category category) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CAT, KEY_ID + " = ?",
                new String[]{String.valueOf(category.getID())});
        db.close();
    }
}
