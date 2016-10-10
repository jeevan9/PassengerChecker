package com.example.passengerchecker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordChangeActivity extends AppCompatActivity {

    EditText t1,t2,t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);
    }
    public void updatepassword(View v)
    {
        t1= (EditText) findViewById(R.id.editText1);
        t2= (EditText) findViewById(R.id.editText2);
        t3= (EditText) findViewById(R.id.editText3);
        String userid=t1.getText().toString();
        String oldpassword=t2.getText().toString();
        String newpassword=t3.getText().toString();
        userid=userid.replace(" ","");
        int flag=0;
        if((userid.equals("")||userid.length()==0)&&oldpassword.length()==0&&newpassword.length()==0)
        {
            flag=1;
            Toast.makeText(this,"Please Enter The userid and OldPassword and NewPassword",Toast.LENGTH_SHORT).show();
        }

        else if((userid.equals("")||userid.length()==0)&&oldpassword.length()==0)
        {
            flag=1;
            Toast.makeText(this,"Please Enter The userid and OldPassword",Toast.LENGTH_SHORT).show();
        }
        else if((userid.equals("")||userid.length()==0)&&newpassword.length()==0)
        {
            flag=1;
            Toast.makeText(this,"Please Enter The userid and NewPassword",Toast.LENGTH_SHORT).show();

        }
        else if(oldpassword.equals("")&&newpassword.length()==0)
        {
            flag=1;
            Toast.makeText(this,"Please Enter The OldPassword and NewPassword",Toast.LENGTH_SHORT).show();

        }

        if(flag!=1)
        {

            if (userid.equals("")||userid.length()==0) {
                flag = 1;
                Toast.makeText(this, "Please Enter The userid", Toast.LENGTH_SHORT).show();

            }

            if (oldpassword.length() == 0) {
                flag = 1;
                Toast.makeText(this, "Please Enter The OldPassword", Toast.LENGTH_SHORT).show();

            }
            if (newpassword.length() == 0) {
                flag = 1;
                Toast.makeText(this, "Please Enter The NewPassword", Toast.LENGTH_SHORT).show();

            }
        }
        if(flag!=1)
        {
            String urlSuffix = "?userid=" + userid + "&oldpassword=" + oldpassword + "&newpassword=" + newpassword;
            UpdatePassword rd = new UpdatePassword(this);
            rd.execute(urlSuffix);
        }
    }
    public void backtologin(View v)
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
