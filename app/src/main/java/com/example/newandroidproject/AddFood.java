package com.example.newandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.newandroidproject.Database.DBHandler;

public class AddFood extends AppCompatActivity {

    EditText mName, price, description;
    Button submit;
    ImageButton ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        submit = findViewById(R.id.btnSubmit);
        mName = findViewById(R.id.txboxmName);
        price = findViewById(R.id.txboxPriceF);
        description = findViewById(R.id.txboxDescF);
        ed = findViewById(R.id.btnED);
    }

    @Override
    protected void onResume() {
        super.onResume();

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                long newID = dbHandler.addInfo(mName.getText().toString(), price.getText().toString(), description.getText().toString());
                Toast.makeText(AddFood.this, "Details Added. Meal ID:"+newID, Toast.LENGTH_SHORT).show();
            }
        });


        ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AddFood.this, EditMenu.class);
                startActivity(intent);

            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = mName.getText().toString();
                String prices = price.getText().toString();

                Intent intent = new Intent(AddFood.this, Burgers.class);
                intent.putExtra("keyname",name);
                intent.putExtra("keyprice",prices);
                startActivity(intent);

            }
        });
    }
}