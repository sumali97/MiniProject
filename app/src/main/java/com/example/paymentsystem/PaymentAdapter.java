package com.example.burgerfactorypayment;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PaymentAdapter extends FragmentPagerAdapter {
    private Context context;
    int totalTabs;

    public PaymentAdapter (FragmentManager fragmentManager, Context context, int totalTabs) {
        super(fragmentManager);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CashPaymentTabFragment cashPaymentTabFragment = new CashPaymentTabFragment();
                return cashPaymentTabFragment;

            case 1:
                OnlinePaymentTabFragment onlinePaymentTabFragment = new OnlinePaymentTabFragment();
                return onlinePaymentTabFragment;

            default:
                return null;
        }
    }
}
