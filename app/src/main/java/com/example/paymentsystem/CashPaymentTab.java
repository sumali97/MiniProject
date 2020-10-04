package com.example.burgerfactorypayment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CashPaymentTab extends AppCompatActivity {

    //insert data
    //create referencer from xml file
    private EditText Name, PhoneNo, Province, District, City, Address;
    private Button Save;
    private DbHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.cash_payment_tab_fragment);

        Name = findViewById(R.id.cash_name);
        PhoneNo = findViewById(R.id.cash_phoneNo);
        Province = findViewById(R.id.cash_province) ;
        District = findViewById(R.id.cash_district);
        City = findViewById(R.id.cash_city);
        Address = findViewById(R.id.cash_address);
        Save = findViewById(R.id.cash_btn_save);

        context = this;
        dbHandler = new DbHandler(context);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = Name.getText().toString();
                String userPhoneNo = PhoneNo.getText().toString();
                String userProvince = Province.getText().toString();
                String userDistrict = District.getText().toString();
                String userCity = City.getText().toString();
                String userAddress = Address.getText().toString();

                CashPaymentDetails cashPaymentDetails = new CashPaymentDetails(userName, userPhoneNo, userProvince, userDistrict, userCity,  userAddress);
                dbHandler.saveCashDetails(cashPaymentDetails);
            }
        });
    }
}
