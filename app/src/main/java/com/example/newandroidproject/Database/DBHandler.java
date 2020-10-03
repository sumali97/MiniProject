package com.example.newandroidproject.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Database.db";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MenuProfile.MenuEntry.TABLE_NAME + " (" +
                    MenuProfile.MenuEntry._ID + " INTEGER PRIMARY KEY," +
                    MenuProfile.MenuEntry.COLUMN_1 + " TEXT," +
                    MenuProfile.MenuEntry.COLUMN_2 + " TEXT," +
                    MenuProfile.MenuEntry.COLUMN_3 + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MenuProfile.MenuEntry.TABLE_NAME;

    public long addInfo(String mName, String price, String description){

        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(MenuProfile.MenuEntry.COLUMN_1, mName);
        values.put(MenuProfile.MenuEntry.COLUMN_2, price);
        values.put(MenuProfile.MenuEntry.COLUMN_3, description);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(MenuProfile.MenuEntry.TABLE_NAME, null, values);

        return newRowId;
    }

    public Boolean updateInfo(String mName, String price, String description) {

        SQLiteDatabase db = getWritableDatabase();

        // New value for one column
        String title = "MyNewTitle";
        ContentValues values = new ContentValues();
        values.put(MenuProfile.MenuEntry.COLUMN_2, price);
        values.put(MenuProfile.MenuEntry.COLUMN_3, description);

        // Which row to update, based on the title
        String selection = MenuProfile.MenuEntry.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = {"mName"};

        int count = db.update(
                MenuProfile.MenuEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        if (count >= 1){
            return true;
        }
        else{
            return false;
        }
    }

    public void deleteInfo(String mName){

        SQLiteDatabase db = getWritableDatabase();

        // Define 'where' part of query.
        String selection = MenuProfile.MenuEntry.COLUMN_1 + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { "mName" };
        // Issue SQL statement.
        int deletedRows = db.delete(MenuProfile.MenuEntry.TABLE_NAME, selection, selectionArgs);
    }

    public List readAllInfo(){
        String mName = "burger";
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                MenuProfile.MenuEntry.COLUMN_1,
                MenuProfile.MenuEntry.COLUMN_2,
                MenuProfile.MenuEntry.COLUMN_3
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = MenuProfile.MenuEntry.COLUMN_1 + " = ?";
        String[] selectionArgs = { "mName" };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                MenuProfile.MenuEntry.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                MenuProfile.MenuEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List mNames = new ArrayList<>();
        while(cursor.moveToNext()) {
            String meal = cursor.getString(
                    cursor.getColumnIndexOrThrow(MenuProfile.MenuEntry.COLUMN_1));
            mNames.add(meal);
        }
        cursor.close();
        return mNames;
    }

    public List readAllInfo(String mName){

        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                MenuProfile.MenuEntry.COLUMN_1,
                MenuProfile.MenuEntry.COLUMN_2,
                MenuProfile.MenuEntry.COLUMN_3
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = MenuProfile.MenuEntry.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { "mName" };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                MenuProfile.MenuEntry.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                MenuProfile.MenuEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List mealInfo = new ArrayList<>();
        while(cursor.moveToNext()) {
            String meal = cursor.getString(cursor.getColumnIndexOrThrow(MenuProfile.MenuEntry.COLUMN_1));
            String price = cursor.getString(cursor.getColumnIndexOrThrow(MenuProfile.MenuEntry.COLUMN_2));
            String description = cursor.getString(cursor.getColumnIndexOrThrow(MenuProfile.MenuEntry.COLUMN_3));
            mealInfo.add(meal); //0
            mealInfo.add(price); //1
            mealInfo.add(description); //2
        }
        cursor.close();
        return mealInfo;
    }

}


