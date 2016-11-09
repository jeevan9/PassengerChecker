package com.example.passengerchecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterVPDetails extends AppCompatActivity {
EditText e1,e2,e3,e4,e5,e6,e7,e8;
    String bname,cardno,chname,expiry,cvvno,mobno,fine,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_vpdetails);
    }
    public void pay(View v)
    {
        e1= (EditText) findViewById(R.id.editText1);
        e2= (EditText) findViewById(R.id.editText2);
        e3= (EditText) findViewById(R.id.editText3);
        e4= (EditText) findViewById(R.id.editText4);
        e5= (EditText) findViewById(R.id.editText5);
        e6= (EditText) findViewById(R.id.editText6);
        e7= (EditText) findViewById(R.id.editText7);
        e8= (EditText) findViewById(R.id.editText8);
        bname=e1.getText().toString();
        cardno=e2.getText().toString();
        chname=e3.getText().toString();
        expiry=e4.getText().toString();
        cvvno=e5.getText().toString();
        mobno=e6.getText().toString();
        fine=e7.getText().toString();
        pass=e8.getText().toString();
        PaymentProcess pp=new PaymentProcess(EnterVPDetails.this);
        pp.execute(bname,cardno,chname,expiry,cvvno,mobno,fine,pass);
    }
}
