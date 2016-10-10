package com.example.passengerchecker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordSetActivity extends AppCompatActivity {
    EditText t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_set);

    }

    public void setPassword(View v)
    {
        t1= (EditText) findViewById(R.id.editText1);
        String userid=t1.getText().toString();
        if(userid.length()==0)
        {
            Toast.makeText(this,"Please enter the userid",Toast.LENGTH_SHORT).show();
        }
        else
        {
            String urlSuffix = userid;
            SetPassword rd = new SetPassword(this);
            rd.execute(urlSuffix);
        }
    }
    public void backtologin(View v)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void resetpassword(View v)
    {
        t1= (EditText) findViewById(R.id.editText1);
        t2= (EditText) findViewById(R.id.editText2);
        t3= (EditText) findViewById(R.id.editText3);
        String userid=t1.getText().toString();
        String otp1=t2.getText().toString();
        String newp=t3.getText().toString();
        int flag=0;
        if((otp1.equals("")||otp1.length()==0)&&newp.length()==0)
        {
            flag=1;
            Toast.makeText(this,"Please Enter OTP and New Password",Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (otp1.equals("") || otp1.length() == 0) {
                flag = 1;
                Toast.makeText(this, "Please Enter userid", Toast.LENGTH_SHORT).show();
            }
            if (newp.length() == 0) {
                flag = 1;
                Toast.makeText(this, "Please Enter The New Password", Toast.LENGTH_SHORT).show();

            }
        }

    }


}
