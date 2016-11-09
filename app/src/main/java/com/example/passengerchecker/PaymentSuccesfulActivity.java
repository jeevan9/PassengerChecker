package com.example.passengerchecker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PaymentSuccesfulActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_succesful);
    }
    public void enterp(View v)
    {
        Intent i=new Intent(this,EnterPassengerDetails.class);
        startActivity(i);
    }
}
