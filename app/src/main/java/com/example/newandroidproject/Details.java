package com.example.newandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    private TextView bName, bPrice, tot;
    EditText qty;
    private ImageButton done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        bName = findViewById(R.id.txtNameD);
        bPrice= findViewById(R.id.txtPriceD);
        qty= findViewById(R.id.txtQuanty);
        tot= findViewById(R.id.txtTotal);
        done= findViewById(R.id.ibtnDone);


        String name = getIntent().getStringExtra("keynameD");
        String prices = getIntent().getStringExtra("keypriceD");
        bName.setText(name);
        bPrice.setText(prices);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double a, b ,c ;
                a = Double.parseDouble(bPrice.getText().toString());
                b = Double.parseDouble(qty.getText().toString());
                c = a * b;
                tot.setText(Double.toString(c));

            }
        });
    }
}