package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.templates.RangeTemplate;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.tutorial.database.DBhandeler;

public class register extends AppCompatActivity {
    EditText fname,emailtxt,pwtxt,conpw,phone,address;
    Button rejister;
    DBhandeler myDBhandler;

    AwesomeValidation awosomevalidation;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        myDBhandler = new DBhandeler(getBaseContext());

        rejister =(Button) findViewById(R.id.rejister);
        fname = (EditText) findViewById(R.id.fname);
        pwtxt =(EditText) findViewById(R.id.pswtxt_val);
        conpw = (EditText)findViewById(R.id.conpw);
        emailtxt=(EditText) findViewById(R.id.emailtxt) ;
        phone = (EditText)findViewById(R.id.phone_no);
        address = (EditText)findViewById(R.id.address_val);



        rejister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("TT",fname.getText().toString());
                addRegData(fname.getText().toString(),emailtxt.getText().toString(),pwtxt.getText().toString(),address.getText().toString(),phone.getText().toString());


            }
        });

        awosomevalidation = new AwesomeValidation(ValidationStyle.BASIC);

        //for name
        awosomevalidation.addValidation(this,R.id.fname,RegexTemplate.NOT_EMPTY,R.string.invalid_name);

        //for email
        awosomevalidation.addValidation(this,R.id.emailtxt, Patterns.EMAIL_ADDRESS,R.string.invalid_Email);

        //for password
        awosomevalidation.addValidation(this,R.id.pwtxt,".{3,}",R.string.invalid_password);

        //for conforim password
        awosomevalidation.addValidation(this,R.id.conpw,RegexTemplate.NOT_EMPTY,R.string.invalid_confirm_password);

        //for address
        awosomevalidation.addValidation(this,R.id.address, RegexTemplate.NOT_EMPTY,R.string.invalid_address);

        //for phone
        awosomevalidation.addValidation(this,R.id.phone,"[5-9]{1}[0-9]{9}$",R.string.invalid_mobile);

        rejister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awosomevalidation.validate()){
                    Toast.makeText(getApplicationContext(),"Form Validate Succefully....",Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(getApplicationContext(),test_Login.class);
                    startActivity(i);
                }

                else{
                    Toast.makeText(getApplicationContext(),"Validtion Failed...",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addRegData(String fname,String e_mail,String passwords, String addresse, String phones){
        Toast.makeText(this, fname, Toast.LENGTH_SHORT).show();
        boolean insertData = myDBhandler.addData(fname,e_mail,passwords,addresse,phones);

        if(insertData){
            Toast.makeText(this, "Data added sucessful", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Data not Added", Toast.LENGTH_SHORT).show();
        }
    }




}