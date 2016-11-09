package com.example.passengerchecker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class VacantSeatsActivity extends AppCompatActivity {
    Spinner spinner1;
public static String source="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacant_seats);
        spinner1= (Spinner) findViewById(R.id.source);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,GetVacancySource.vacantcoaches);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(VacantSeatsActivity.this, "Selected Source is "+parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                source= (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(VacantSeatsActivity.this, "Please Select the Coach ", Toast.LENGTH_SHORT).show();

            }
        });
    }
  /* public void vacancy(View v)
    {
        RetrieveVacantSeatsList rvl1=new RetrieveVacantSeatsList(VacantSeatsActivity.this);
        rvl1.execute();
    //VacantSeatsListActivity
    }*/
    public void vac(View v)
    {
        RetrieveVacantSeatsList rvl1=new RetrieveVacantSeatsList(VacantSeatsActivity.this);
        rvl1.execute();
    }
}
