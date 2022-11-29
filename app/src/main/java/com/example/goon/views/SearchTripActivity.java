package com.example.goon.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goon.R;
import com.example.goon.models.Trips;


import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SearchTripActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    List<Trips> tripsList= new ArrayList<>();
    AdapterSearchTrip adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_trip);
        setData();
        //initializeFirebase();
        showData();
    }

    private void showData() {
        Trips t = new Trips();
        t.setArrival("dddddd");
        t.setRoute("d turasas");
         tripsList.add(t);

         adapter = new AdapterSearchTrip(SearchTripActivity.this,tripsList);
         recyclerView.setAdapter(adapter);
         recyclerView.setLayoutManager(new LinearLayoutManager(SearchTripActivity.this));
    }

    private void setData() {
        recyclerView= findViewById(R.id.rvTrips);
    }
}