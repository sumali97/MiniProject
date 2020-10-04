package com.example.tutorial.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.tutorial.feedback;

import java.util.ArrayList;
import java.util.List;

public class DBhandeler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "database.db";

    public DBhandeler(Context context) {
        super(context, "userprofile", null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE userprofile ( full_name TEXT,email TEXT,password TEXT,address TEXT,phone Integer)";
        sqLiteDatabase.execSQL(createTable);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS userprofile");

        onCreate(sqLiteDatabase);
    }


    public boolean addData(String fname,String e_mail,String passwords, String addresse, String phones){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("full_name",fname);
        contentValues.put("email",e_mail);
        contentValues.put("password",passwords);
        contentValues.put("address",addresse);
        contentValues.put("phone",phones);

        Log.d("TAG","addData Adding "+fname + " to userprofile" );


        long result = db.insert("userprofile", null,contentValues);

        //if data as inserted incorrectly it will return -1
        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }





    //    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(SQL_CREATE_ENTRIES);
//    }
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        // This database is only a cache for online data, so its upgrade policy is
//        // to simply to discard the data and start over
//        db.execSQL(SQL_DELETE_ENTRIES);
//        onCreate(db);
//    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

//   // private static final String SQL_CREATE_ENTRIES =
//           "CREATE TABLE " + userprofile.users.TABLE_NAME + " (" +
//                    userprofile.users._ID + " INTEGER PRIMARY KEY," +
//                   userprofile.users.COLUMN_1 + " TEXT," +
//                    userprofile.users.COLUMN_2 + " TEXT," +
//                    userprofile.users.COLUMN_3 + " TEXT," +
//                    userprofile.users.COLUMN_4 + " TEXT," +
//                    userprofile.users.COLUMN_5 + " INTEGER," +





    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + userprofile.users.TABLE_NAME;


    public long addinfo(String full_name,String email,String password, String address, int phone){

        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(userprofile.users.COLUMN_1, full_name);
        values.put(userprofile.users.COLUMN_2, email);
        values.put(userprofile.users.COLUMN_3, password);
        values.put(userprofile.users.COLUMN_4, address);
        values.put(userprofile.users.COLUMN_5, phone);


        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(userprofile.users.TABLE_NAME, null, values);

        return newRowId;

    }



    public Boolean updateinfo(String full_name,String email,String password, String address, int phone){

        SQLiteDatabase db = getWritableDatabase();

        // New value for one column

        ContentValues values = new ContentValues();
        values.put(userprofile.users.COLUMN_2, email);
        values.put(userprofile.users.COLUMN_3, password);
        values.put(userprofile.users.COLUMN_4, address);
        values.put(userprofile.users.COLUMN_5, phone);

        // Which row to update, based on the title
        String selection = userprofile.users.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { full_name };

        int count = db.update(
                userprofile.users.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        if(count >=1){
            return true;
        }
        else{
            return false;
        }
    }


    public void deleteinfo(String full_name){

        SQLiteDatabase db = getWritableDatabase();

        // Define 'where' part of query.
        String selection = userprofile.users.COLUMN_1 + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { "MyTitle" };
        // Issue SQL statement.
        int deletedRows = db.delete(userprofile.users.TABLE_NAME, selection, selectionArgs);
    }


    //retrive data
    public Cursor alldata(){
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from userprofile", null);
        return  cursor;



    }
//    public List readAllinfo(){
//
//        String full_name = "Pasindu";
//        SQLiteDatabase db = getReadableDatabase();
//
//        // Define a projection that specifies which columns from the database
//        // you will actually use after this query.
//        String[] projection = {
//                BaseColumns._ID,
//                userprofile.users.COLUMN_1,
//                userprofile.users.COLUMN_2,
//                userprofile.users.COLUMN_3,
//                userprofile.users.COLUMN_4,
//                userprofile.users.COLUMN_5,
//
//        };
//
//        // Filter results WHERE "title" = 'My Title'
//        String selection = userprofile.users.COLUMN_1 + " = ?";
//        String[] selectionArgs = { full_name };
//
//        // How you want the results sorted in the resulting Cursor
//        String sortOrder =
//                userprofile.users.COLUMN_1 + " ASC";
//
//        Cursor cursor = db.query(
//                userprofile.users.TABLE_NAME,   // The table to query
//                projection,             // The array of columns to return (pass null to get all)
//                selection null,           // The columns for the WHERE clause
//                selectionArgs null,          // The values for the WHERE clause
//               ***// groupBy null,                   // don't group the rows
//             ***   //having null,                   // don't filter by row groups
//                sortOrder              // The sort order
//        );
//
//        List full_name = new ArrayList<>();
//        while(cursor.moveToNext()) {
//            String users = cursor.getString(cursor.getColumnIndexOrThrow(userprofile.users.COLUMN_1));
//            full_name.add(users);
//        }
//        cursor.close();
//
//        return full_name;
//    }
//
//    public List readAllinfo(String full_name){
//
//
//        SQLiteDatabase db = getReadableDatabase();
//
//        // Define a projection that specifies which columns from the database
//        // you will actually use after this query.
//        String[] projection = {
//                BaseColumns._ID,
//                userprofile.users.COLUMN_1,
//                userprofile.users.COLUMN_2,
//                userprofile.users.COLUMN_3,
//                userprofile.users.COLUMN_4,
//                userprofile.users.COLUMN_5,
//
//        };
//
//        // Filter results WHERE "title" = 'My Title'
//        String selection = userprofile.users.COLUMN_1 + " LIKE ?";
//        String[] selectionArgs = { full_name };
//
//        // How you want the results sorted in the resulting Cursor
//        String sortOrder =
//                userprofile.users.COLUMN_1 + " ASC";
//
//        Cursor cursor = db.query(
//                userprofile.users.TABLE_NAME,   // The table to query
//                projection,             // The array of columns to return (pass null to get all)
//                selection,           // The columns for the WHERE clause
//                selectionArgs,          // The values for the WHERE clause
//               ***// groupBy null,                   // don't group the rows
//             ***   //having null,                   // don't filter by row groups
//                sortOrder              // The sort order
//        );
//
//        List UserInfo = new ArrayList<>();
//        while(cursor.moveToNext()) {
//            String User = cursor.getString(cursor.getColumnIndexOrThrow(userprofile.users.COLUMN_1));
//            String Mail = cursor.getString(cursor.getColumnIndexOrThrow(userprofile.users.COLUMN_2));
//            String Pass = cursor.getString(cursor.getColumnIndexOrThrow(userprofile.users.COLUMN_3));
//            String Address = cursor.getString(cursor.getColumnIndexOrThrow(userprofile.users.COLUMN_4));
//            String Phone = cursor.getString(cursor.getColumnIndexOrThrow(userprofile.users.COLUMN_5));
//
//            UserInfo.add(User);//0
//            UserInfo.add(Mail);//1
//            UserInfo.add(Pass);//2
//            UserInfo.add(Address);//3
//            UserInfo.add(Phone);//4
//        }
//        cursor.close();
//
//        return UserInfo;
//    }
//
//    public Boolean Login(String email,String password){
//
//        SQLiteDatabase db = getReadableDatabase();
//
//        // Define a projection that specifies which columns from the database
//        // you will actually use after this query.
//        String[] projection = {
//                BaseColumns._ID,
//                userprofile.users.COLUMN_2,
//                userprofile.users.COLUMN_3
//        };
//
//        // Filter results WHERE "title" = 'My Title'
//        String selection = userprofile.users.COLUMN_2 + " = ? AND "+ userprofile.users.COLUMN_3 +"= ?";
//        String[] selectionArgs = { email, password};
//
//        // How you want the results sorted in the resulting Cursor
//        String sortOrder =
//                userprofile.users.COLUMN_2+ " ASC";
//
//        Cursor cursor = db.query(
//                userprofile.users.TABLE_NAME,   // The table to query
//                projection,             // The array of columns to return (pass null to get all)
//                selection,              // The columns for the WHERE clause
//                selectionArgs,          // The values for the WHERE clause
//                null,                   // don't group the rows
//                null,                   // don't filter by row groups
//                sortOrder               // The sort order
//        );
//
//        List validuser = new ArrayList();
//        while(cursor.moveToNext()) {
//            String user = cursor.getString(cursor.getColumnIndexOrThrow(userprofile.users.COLUMN_2));
//            validuser.add(user)
//
//        }
//        cursor.close();
//
//        if (validuser.isEmpty()){
//            return false;
//        }
//        else {
//            return true;
//        }

//    }
}