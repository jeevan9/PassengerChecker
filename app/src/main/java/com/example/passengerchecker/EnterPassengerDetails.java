package com.example.passengerchecker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterPassengerDetails extends AppCompatActivity {
    EditText e1,e2,e3,e4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_passenger_details);
    }
    public void update(View v)
    {
        String pname="",age="",sex="",mobileno="";
        e1= (EditText) findViewById(R.id.editText1);
        e2= (EditText) findViewById(R.id.editText2);
        e3= (EditText) findViewById(R.id.editText3);
        e4= (EditText) findViewById(R.id.editText4);
        pname=e1.getText().toString();
        age=e2.getText().toString();
        sex=e3.getText().toString();
        mobileno=e4.getText().toString();
        UpdateVacantPassenger uvp=new UpdateVacantPassenger(this);
        uvp.execute(pname,age,sex,mobileno);
    }
    public void backtologin(View v)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
