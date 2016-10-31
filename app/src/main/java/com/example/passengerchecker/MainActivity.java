package com.example.passengerchecker;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText t1,t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void login(View v)
    {
        t1=(EditText)findViewById(R.id.editText1);
        t2=(EditText)findViewById(R.id.editText2);
        String userid=t1.getText().toString();
        String password=t2.getText().toString();
        userid=userid.replace(" ","");
        int flag=0;
        if((userid.equals("")||userid.length()==0)&&password.length()==0)
        {
            flag=1;
            Toast.makeText(this,"Please Enter userid and Password",Toast.LENGTH_SHORT).show();
        }
        else
        {
            if (userid.equals("") || userid.length() == 0) {
                flag = 1;
                Toast.makeText(this, "Please Enter userid", Toast.LENGTH_SHORT).show();
            }
            if (password.length() == 0) {
                flag = 1;
                Toast.makeText(this, "Please Enter The Password", Toast.LENGTH_SHORT).show();

            }
        }
        if(flag!=1)
        {
            String urlSuffix = "?userid="+userid+"&password="+password;
            Login rd = new Login(this);
            rd.execute(urlSuffix);
        }
    }

    public void forgotpassword(View v)
    {
        Intent i=new Intent(this,PasswordSetActivity.class);
        startActivity(i);
    }

}
