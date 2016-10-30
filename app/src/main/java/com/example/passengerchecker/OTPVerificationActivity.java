package com.example.passengerchecker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OTPVerificationActivity extends AppCompatActivity {

    EditText t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);
    }

    public void resetpass(View v) {
        t1 = (EditText) findViewById(R.id.editText1);
        t2 = (EditText) findViewById(R.id.editTexto);
        String password = t1.getText().toString();
        String otppass = t2.getText().toString();
        Intent i = getIntent();
        int flag=0;
        if(otppass.length()==0)
        {
            flag=1;
            Toast.makeText(this, "Please Enter OTP", Toast.LENGTH_SHORT).show();
        }
        if (password.length() == 0) {
            flag=1;
            Toast.makeText(this, "Please Enter new password", Toast.LENGTH_SHORT).show();
        }
        if(flag!=1) {
            String username = i.getStringExtra("uname");
            String otp = i.getStringExtra("otp");
            OTPSetPassword ot = new OTPSetPassword(this);
            ot.execute(username, password, otp, otppass);
        }
    }

    public void loginback(View v)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
