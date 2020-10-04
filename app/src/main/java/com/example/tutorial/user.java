package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.FontsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tutorial.database.DBhandeler;

public class user extends AppCompatActivity {

    EditText user, mail,pass,address,phone;
    Button feeds;
    private DBhandeler db = new DBhandeler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        user = (EditText)findViewById(R.id.fname);
        mail =(EditText) findViewById(R.id.emailtxt);
        pass =(EditText) findViewById(R.id.pswtxt_val);
        address =(EditText) findViewById(R.id.address_val);
        phone = (EditText) findViewById(R.id.phone_no);

        feeds =(Button) findViewById(R.id.feed);

        feeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent i = new Intent(getApplicationContext(),feedback.class);
                startActivity(i);

            }
        });

            // retrieve

        //Log.d("CCX",db.getDatabaseName());
        Cursor cursor = db.alldata();
        if(cursor.getCount()==0){
            Toast.makeText(getApplicationContext(),"NO DATA",Toast.LENGTH_SHORT).show();
          }
            else{
                while (cursor.moveToNext()){
                    Toast.makeText(getApplicationContext(),"user"+cursor.getString(0),Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),"mail"+cursor.getString(1),Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),"pass"+cursor.getString(2),Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),"address"+cursor.getString(3),Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),"phone"+cursor.getString(4),Toast.LENGTH_SHORT).show();

                    user.setText(cursor.getString(0));
                    mail.setText(cursor.getString(1));
                    pass.setText(cursor.getString(2));
                    address.setText(cursor.getString(3));
                    phone.setText(cursor.getString(4));


                }
        }
    }
}