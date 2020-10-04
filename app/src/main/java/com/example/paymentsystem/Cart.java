package com.example.paymentsystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {
    ListView listView;

    private DbHandler dbHandler;
    private List<PaymentDetails> displayData;

    //Array data list (this should be connected sumali's data base)
    int[] image = { R.drawable.cheese, R.drawable.onion, R.drawable.mixed};
    String[] food_name = new String[] { "Cheese Burger", "Chicken Burger with Onion", "Mixed King Burger"};
    double[] food_price = new double[] { 300.00, 380.00, 430.00};
    int[] total_per_row = new int[] {2, 3, 1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        displayData = new ArrayList<>();

        displayData = dbHandler.getAllDetails();

        //ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_row, R.id.row_food_name, food_name);
        listView = findViewById(R.id.cart_listView);
        CustomAdapter customAdapter = new CustomAdapter(this, food_name, image, food_price, total_per_row);
        listView.setAdapter(customAdapter);

    }
}

//*****************************************************************************************************************
class CustomAdapter extends ArrayAdapter<String>{
    Context context;
    String[] food_nameV;
    int[] imageV;
    double[] food_priceV;
    int[] quantityV;
    int[] totalItemPrice;



    CustomAdapter(Context c, String[] food_name, int[] image ,double[] food_price, int[] total_per_row) {
        super(c, R.layout.list_row, R.id.row_food_name, food_name);
        this.context = c;
        this.imageV = image;
        this.food_nameV = food_name;
        this.food_priceV = food_price;
        this.quantityV = total_per_row;




    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.list_row, parent, false);

        ImageView imageView = row.findViewById(R.id.cart_img);
        TextView textViewName = row.findViewById(R.id.row_food_name);
        TextView textViewPrice = row.findViewById(R.id.row_food_price);
        TextView textViewTotalPerFood = row.findViewById(R.id.row_total);
        TextView textViewQuantity = row.findViewById(R.id.row_quntity);


        imageView.setImageResource(imageV[position]);
        textViewName.setText(food_nameV[position]);
        textViewPrice.setText((int) food_priceV[position]);
        textViewQuantity.setText(quantityV[position]);

        totalItemPrice[position] = ((int) food_priceV[position] * quantityV[position]);
        textViewTotalPerFood.setText(totalItemPrice[position]);


        return row;
    }



}