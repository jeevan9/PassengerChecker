package com.example.passengerchecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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
}
