package com.example.paymentsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CartAdapter extends ArrayAdapter<DisplayData> {
    private Context context;
    private int resource;
    List<displayData>

    CartAdapter(Context context, int resource) {
        super(context, resource, List<DisplayData> displayData);
        this.context = context;
        this.resource = resource;
        this.displayData = displayData;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent, false);

        TextView Name = row.findViewById(R.id.name);
        TextView Price = row.findViewById(R.id.price);
        TextView Quantity = row.findViewById(R.id.quantity);
        TextView totolprice = row.findViewById(R.id.total_price);
        TextView  deliveryprice= row.findViewById(R.id.deli_price);
        TextView finaltotal = row.findViewById(R.id.final_total);

        PaymentDetails paymentDetails = displayData.get(position);
        Price.setText(paymentDetails.getTotalOfFodds());
        Quantity.setText(paymentDetails.getQuantity());
        totolprice.setText(paymentDetails.getSubTotal());
        deliveryprice.setText(paymentDetails.getDeliveryPeice());
        finaltotal.setText(paymentDetails.getTotal());
        Name.setText(paymentDetails.getFoodName());
    }


}
