package com.example.passengerchecker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class VacantSeatsListActivity extends AppCompatActivity {
    private RecyclerView rv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacant_seats_list);
        rv1=(RecyclerView)findViewById(R.id.rv1);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv1.setLayoutManager(llm);
        rv1.setHasFixedSize(true);
        initializeAdapter();
    }
    private void initializeAdapter(){
        VacantListAdapater adapter = new VacantListAdapater(RetrieveVacantSeatsList.vacantArrayList,VacantSeatsListActivity.this);
        rv1.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        RetrieveVacantSeatsList.vacantArrayList.clear();
    }
}
