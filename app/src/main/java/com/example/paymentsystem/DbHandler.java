package com.example.paymentsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.ContentView;
import androidx.annotation.Nullable;

import com.example.paymentsystem.PaymentDetails;

public class DbHandler extends SQLiteOpenHelper {

    private static final int VERSION = 2;
    private static final String DB_NAME = "payment_system";
    public static final String TABLE_NAME_01 = "payment";

    private static final String ORDER_ID = "order_id";

    private static final String SUB_TOTAL = "sub_total";
    private static final String DELIVERY_PRICE = "delivry_price";
    private static final String TOTAL = "total";

    private static final String FOOD_NAME_ = "food_name_";
    private static final String QUANTITY = "quantity";
    private static final String PRICE_FOOD = "price_food";

    public static final String TABLE_NAME_02 = "cashPaymentDetails";

    private static final String ID = "id";
    private static final String FULL_NAME = "full_name";
    private static final String PHONE_NO = "phone_no";
    private static final String PROVINCE = "province";
    private static final String DISTRICT = "district";
    private static final String CITY = "city";
    private static final String ADDRESS = "address";

    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    private static final String TABLE_CREATE_QUERY = "CREATE TABLE payment (ORDER_ID INTEGER PRIMARY KEY AUTOINCREMENT" +
            " , SUB_TOTAL DOUBLE " +
            " , DELIVERY_PRICE DOUBLE" +
            " , TOTAL DOUBLE" +
            " , FOOD_NAME_ TEXT" +
            " , QUANTITY INTEGER" +
            " , PRICE_FOOD DOUBLE)";

    private static final String TABLE_CREATE_QUERY2 = "CREATE TABLE cash_payment_details (ID INTEGER PRIMARY KEY AUTOINCREMENT" +
            " , FULL_NAME TEXT NOT NULL" +
            " , PHONE_NO NOT NULL"  +
            " , PROVINCE TEXT NOT NULL"+
            " , DISTRICT TEXT NOT NULL" +
            ", CITY TEXT NOT NULL" +
            ", ADDRESS TEXT NOT NULL)";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY);
        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS payment";
        sqLiteDatabase.execSQL(DROP_TABLE_QUERY);
        onCreate(sqLiteDatabase);

        String DROP_TABLE_QUERY2 = "DROP TABLE IF EXISTS payment";
        sqLiteDatabase.execSQL(DROP_TABLE_QUERY);
        onCreate(sqLiteDatabase);
    }

    //insert data
    public void submitOrder (PaymentDetails paymentDetails) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(SUB_TOTAL, paymentDetails.getSubTotal());
        contentValues.put(DELIVERY_PRICE, paymentDetails.getDeliveryPeice());
        contentValues.put(TOTAL, paymentDetails.getTotal());
        contentValues.put(FOOD_NAME_, paymentDetails.getFoodName());
        contentValues.put(QUANTITY, paymentDetails.getQuantity());
        contentValues.put(PRICE_FOOD, paymentDetails.getTotalOfFodds());

        //save data to the table
        sqLiteDatabase.insert(TABLE_NAME_01, null,contentValues);

        //close the database
        sqLiteDatabase.close();
    }

    //insert data
    //get 'cashPaymentDetails' object which assined input values from 'CashPaymentTab'
    public void saveCashDetails (com.example.burgerfactorypayment.CashPaymentDetails cashPaymentDetails) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(FULL_NAME, cashPaymentDetails.getFull_name());
        contentValues.put(PHONE_NO, cashPaymentDetails.getPhone_no());
        contentValues.put(PROVINCE, cashPaymentDetails.getProvince());
        contentValues.put(DISTRICT, cashPaymentDetails.getDistrict());
        contentValues.put(CITY, cashPaymentDetails.getCity());
        contentValues.put(ADDRESS, cashPaymentDetails.getAddress());

        //save data to the table
        sqLiteDatabase.insert(TABLE_NAME_01, null,contentValues);

        //close the database
        sqLiteDatabase.close();
    }
}

