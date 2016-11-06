package com.example.passengerchecker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PListSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plist_success);
    }
    public void home(View v)
    {
        Intent i= new Intent(this,NavigationActivity.class);
        startActivity(i);
    }
    public void vacantseats(View v)
    {
        GetVacancySource gvc=new GetVacancySource(this);
        gvc.execute();
    }
}
