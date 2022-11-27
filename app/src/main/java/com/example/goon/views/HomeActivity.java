package com.example.goon.views;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goon.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button btnUser, btnDriver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setReferences();
        //
    }
    private void setReferences(){
        btnUser=findViewById(R.id.btnHomeUser);
        btnDriver=findViewById(R.id.btnHomeDriver);
        btnUser.setOnClickListener(this::onClick);
        btnDriver.setOnClickListener(view -> {
            Intent intent = new Intent(this, SearchTripActivity.class);
            startActivity(intent);
        });
    }

    private void onClick(View view) {
        Intent intent = new Intent(this, SearchTripActivity.class);
        startActivity(intent);
    }
}