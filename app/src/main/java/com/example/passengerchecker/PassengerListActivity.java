package com.example.passengerchecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.List;

public class PassengerListActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_list);
        rv=(RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);
        initializeAdapter();
    }
    private void initializeAdapter(){
        PassengerListAdapter adapter = new PassengerListAdapter(RetrievePassengerList.passengerArrayList,PassengerListActivity.this);
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
