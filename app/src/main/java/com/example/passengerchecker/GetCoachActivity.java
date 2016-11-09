package com.example.passengerchecker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class GetCoachActivity extends AppCompatActivity  {
    Spinner spinner1;
    GetCoach gc1=new GetCoach();
   // RetrievePassengerList.callback callback;
    public String cno="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_coach);
        spinner1= (Spinner) findViewById(R.id.coachno);
      /*  ArrayList<String> s=new ArrayList<String>();
        s.add("S1");
        s.add("S2");
        s.add("S3");
        */ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,gc1.coaches);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GetCoachActivity.this, "Selected Coach is "+parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                cno= (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(GetCoachActivity.this, "Please Select the Coach ", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void passengerlist(View v)
    {
        RetrievePassengerList rpl=new RetrievePassengerList(GetCoachActivity.this);
        //rpl.setInit(this);
        rpl.execute(cno);
    }

   /* @Override
    public void send(ArrayList<Passenger> passengers) {

       // Intent intent=new Intent(GetCoachActivity.this,PassengerListActivity.class);
        //intent.putParcelableArrayListExtra("list",passengers);

        Intent i = new Intent(GetCoachActivity.this,PassengerListActivity.class);
        //i.putExtra("obj", wrapper);
        i.putExtra("student", passengers);
        startActivity(i);
    }*/
}
