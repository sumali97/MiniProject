package com.example.newandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i( tag: "Lifecycle", msg: "onCreate called... ");

        TextView TvMsg2 = findViewById(R.id.TvMsg2);
        TvMsg2.setText(R.string.Msg2);
    }
    public void onStart()
    {
        super.onStart();
        Log.i( tag: "Lifecycle", msg:"onStart called...");
    }
    public void onRestart()
    {
        super.onRestart();
        Log.i( tag: "Lifecycle", msg:"onRestart called...");
    }




}