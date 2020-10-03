package com.example.newandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.newandroidproject.Database.DBHandler;

import java.util.List;

public class Findmeal extends AppCompatActivity {

    EditText mName, price, description;
    ImageButton search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findmeal);

        search = findViewById(R.id.btnSearch);
        mName = findViewById(R.id.editName);
        price = findViewById(R.id.editPrice);
        description = findViewById(R.id.editDescription);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                List meal = dbHandler.readAllInfo(mName.getText().toString());

                if (meal.isEmpty()){
                    Toast.makeText(Findmeal.this, "No Meal", Toast.LENGTH_SHORT).show();
                    mName.setText(null);
                }
                else{
                    Toast.makeText(Findmeal.this, "Meal Found Meal:"+meal.get(0).toString(), Toast.LENGTH_SHORT).show();
                    mName.setText(meal.get(0).toString());
                    price.setText(meal.get(1).toString());
                    description.setText(meal.get(2).toString());
                }
            }
        });
    }
}