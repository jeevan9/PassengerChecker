package com.example.passengerchecker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TrainBogiActivity extends AppCompatActivity {
TextView t1,t2;

    DateVerification tn=new DateVerification();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_bogi);
        t1= (TextView) findViewById(R.id.tnumber);
        t2= (TextView) findViewById(R.id.tname);
        t1.setText(tn.trainnumber);
        t2.setText(tn.trainname);

    }

    public void getcoach(View v)
    {
       GetCoach gc=new GetCoach(this);
        gc.execute();
    }
}
