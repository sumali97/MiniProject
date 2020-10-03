package com.example.newandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newandroidproject.Database.DBHandler;

import java.util.List;

public class EditMenu extends AppCompatActivity {

    EditText mName, price, description;
    Button edit,search,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findmeal);

        delete = findViewById(R.id.btnDelete);
        edit = findViewById(R.id.btnEdit);
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
                    Toast.makeText(EditMenu.this, "No Meal", Toast.LENGTH_SHORT).show();
                    mName.setText(null);
                }
                else{
                    Toast.makeText(EditMenu.this, "Meal Found Meal:"+meal.get(0).toString(), Toast.LENGTH_SHORT).show();
                    mName.setText(meal.get(0).toString());
                    price.setText(meal.get(1).toString());
                    description.setText(meal.get(2).toString());
                }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHandler dbHandler = new DBHandler(getApplicationContext());

                Boolean status = dbHandler.updateInfo(mName.getText().toString(),price.getText().toString(),description.getText().toString());
                if (status){
                    Toast.makeText(EditMenu.this, "Menu Updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(EditMenu.this, "Update Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                dbHandler.deleteInfo(mName.getText().toString());

                Toast.makeText(EditMenu.this, "Meal Deleted", Toast.LENGTH_SHORT).show();

                mName.setText(null);
                price.setText(null);
                description.setText(null);

            }
        });
    }
}