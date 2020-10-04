package com.example.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.tutorial.database.DBhandeler;

public class test_Login extends AppCompatActivity {
    Button  signbtn;
    EditText email,password;

    AwesomeValidation validate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__login);

        email =(EditText) findViewById(R.id.emailtxt);
        password =(EditText) findViewById(R.id.pwtxt);

        signbtn = (Button) findViewById(R.id.signinbtn);

        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

            Intent intent = new Intent(getApplicationContext(),user.class);

            //initialize validation
            validate = new AwesomeValidation(ValidationStyle.BASIC);

            //add valid for Email
       validate.addValidation(this,R.id.emailtxt, Patterns.EMAIL_ADDRESS,R.string.invalid_Email);


        //add valid for password
      validate.addValidation(this,R.id.pwtxt,
               ".{3,}",R.string.invalid_password );
        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate.validate()){
                    Toast.makeText(getApplicationContext(),"From Valid Data...",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),user.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"validation Fail...",Toast.LENGTH_SHORT).show();
                }
            }
        });



/*

                DBhandeler DBhandeler = new DBhandeler.(getApplicationContext());
              If(DBhandeler.Login(email.getText().toString(),password.getText().toString())){

                Toast.makeText(this, "Logging IS Successfully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(),user.class);
                startActivity(i);
                }
                else{
                    Toast.makeText(this, "No User Invalid Details", Toast.LENGTH_SHORT).show();
                    email.setText(null);
                    password.setText(null);
*/


           }
}