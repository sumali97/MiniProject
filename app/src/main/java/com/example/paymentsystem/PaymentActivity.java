package com.example.burgerfactorypayment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class PaymentActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    float v =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        tabLayout.addTab(tabLayout.newTab().setText("Cash On Delivery"));
        tabLayout.addTab(tabLayout.newTab().setText("Online Payment"));

        final com.example.burgerfactorypayment.PaymentAdapter paymentAdapter = new com.example.burgerfactorypayment.PaymentAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());
        viewPager.setAdapter(paymentAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setTranslationY(300);
        tabLayout.setAlpha(v);
        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();
    }
}