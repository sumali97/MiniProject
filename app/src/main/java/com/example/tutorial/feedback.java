package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tutorial.database.DBDAFeedback;

public class feedback extends AppCompatActivity {
    EditText full_name,email_txt,comments;
    Button sub;
    DBDAFeedback myDBDAFeedback;


    private DBDAFeedback db = new DBDAFeedback(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        full_name = (EditText)findViewById(R.id.fullname);
        email_txt =(EditText) findViewById(R.id.emailtxt);
        comments =(EditText) findViewById(R.id.comment);
        sub = (Button)findViewById(R.id.submit);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addfeed(full_name.getText().toString(),email_txt.getText().toString(),comments.getText().toString());
                Intent x = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(x);
            }
        });



    }
    private void addfeed(String full_name,String email,String message){
        boolean insertData = db.addfeed(full_name,email,message);

        if(insertData){
            Toast.makeText(this, "Send Feedback Successfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Not Added Feedback Unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }
}