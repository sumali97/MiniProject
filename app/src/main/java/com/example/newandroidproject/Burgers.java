package com.example.newandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Burgers extends AppCompatActivity {

    private TextView bname, bprice;
            Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burgers);

        bname = findViewById(R.id.txtBurger);
        bprice= findViewById(R.id.txtPrice);
        add = findViewById(R.id.btnAdd2);

        String name = getIntent().getStringExtra("keyname");
        String prices = getIntent().getStringExtra("keyprice");
        bname.setText(name);
        bprice.setText(prices);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = bname.getText().toString();
                String prices = bprice.getText().toString();

                Intent intent = new Intent(Burgers.this, Details.class);
                intent.putExtra("keynameD",name);
                intent.putExtra("keypriceD",prices);
                startActivity(intent);

            }
        });

    }
}