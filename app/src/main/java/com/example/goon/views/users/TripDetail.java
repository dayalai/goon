package com.example.goon.views.users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.goon.R;
import com.example.goon.models.Trips;
import com.example.goon.views.SearchTripActivity;

import java.util.ArrayList;
import java.util.List;

public class TripDetail extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageButton btnBack;
    Button btnTakeTrip;
    List<Trips> tripsList=new ArrayList<>();
    AdapterTripDetail adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_detail);
        setData();
        showData();
    }
    private void setData(){
        recyclerView=findViewById(R.id.rvTripDetail);
        btnBack=findViewById(R.id.btnBackTripDetail);
        btnBack.setOnClickListener(view -> {
            Intent intent=new Intent(this, SearchTripActivity.class);
            startActivity(intent);
        });
        btnTakeTrip=findViewById(R.id.btnTakeTrip);
       // btnTakeTrip.setOnClickListener(view -> {
         //   Intent intent = new Intent(this,ConfirmationTrip.class);
           // startActivity(intent);
      //  });
    }
    private void showData() {
        Trips t = new Trips();
        t.setArrival("dddddd");
        t.setRoute("d turasas");
        tripsList.add(t);

        adapter=new AdapterTripDetail(TripDetail.this,tripsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(TripDetail.this));
    }
}