package com.example.goon.views.driver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.goon.R;
import com.example.goon.models.Car;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListarCarActivity extends AppCompatActivity {

    RecyclerView rvCar;
    FloatingActionButton btnNuevo;

    FirebaseDatabase database;
    DatabaseReference reference;

    List<Car> listaCar = new ArrayList<>();
    AdaptadorCar adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_car);
        asignarReferencias();
        inicializarFirebase();
        mostrarDatos();
    }
    private void asignarReferencias(){
        rvCar = findViewById(R.id.rvVehiculos);
        btnNuevo = findViewById(R.id.btnNuevo);
        btnNuevo.setOnClickListener(view -> {
            Intent intent = new Intent(this,MainCarActivity.class);
            startActivity(intent);
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                int pos = viewHolder.getAdapterPosition();
                String id = listaCar.get(pos).getUid();
                listaCar.remove(pos);
                adaptador.notifyDataSetChanged();
                reference.child("Persona").child(id).removeValue();
            }
        }).attachToRecyclerView(rvCar);
    }
    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        database=FirebaseDatabase.getInstance();
        reference = database.getReference();
    }
    private void mostrarDatos(){
        reference.child("Persona").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listaCar.clear();
                for(DataSnapshot item: snapshot.getChildren()){
                    Car p = item.getValue(Car.class);
                    if(p.getDriveruid().equals("test")){
                        listaCar.add(p);
                    }
                }
                adaptador = new AdaptadorCar(ListarCarActivity.this,listaCar);
                rvCar.setAdapter(adaptador);
                rvCar.setLayoutManager(new LinearLayoutManager(ListarCarActivity.this));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}