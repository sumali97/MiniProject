package com.example.tutorial.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.tutorial.feedback;

import static com.example.tutorial.database.DBhandeler.DATABASE_VERSION;

public class DBDAFeedback extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "database.db";

    public DBDAFeedback(Context context) {
        super(context, "feedback", null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE feedback ( full_name TEXT,email TEXT,message TEXT)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS feedback");

        onCreate(sqLiteDatabase);
    }

    public boolean  addfeed(String fullname,String e_mail,String message){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name",fullname);
        contentValues.put("email",e_mail);
        contentValues.put("message",message);


        Log.d("TAG","addData Adding "+fullname + " to feedback" );


        long result = db.insert("feedback", null,contentValues);

        //if data as inserted incorrectly it will return -1
        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public long feedback(String full_name,String email,String message){



        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(userprofile.feed.COLUMN_1, full_name);
        values.put(userprofile.feed.COLUMN_2, email);
        values.put(userprofile.feed.COLUMN_3, message);



        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(userprofile.feed.TABLE_NAME, null, values);

        return newRowId;

    }
}
