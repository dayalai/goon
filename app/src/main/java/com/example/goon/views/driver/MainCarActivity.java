package com.example.goon.views.driver;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.goon.R;
import com.example.goon.models.Car;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.UUID;

public class MainCarActivity extends AppCompatActivity {

    EditText txtPlaca, txtMarca, txtModelo,txtAnio;
    Button btnRegistrar;
    TextView titulo;
    Car car;
    FirebaseDatabase database;
    DatabaseReference reference;
    boolean registra = true;
    String id;
    HashMap map = new HashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_car);
        asignarReferencias();
        inicializarFirebase();
        verificarModificar();
    }

    private void asignarReferencias(){
        txtPlaca = findViewById(R.id.txtPlaca);
        txtMarca = findViewById(R.id.txtMarca);
        txtModelo = findViewById(R.id.txtModelo);
        txtAnio = findViewById(R.id.txtAnio);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        titulo = findViewById(R.id.txttitulo);
        btnRegistrar.setOnClickListener(view -> {
            capturarDatos();
            if(registra){
                reference.child("Car").child(car.getUid()).setValue(car);
                mostrarMensaje("Auto Registrado");
            }else {
                reference.child("Car").child(id).updateChildren(map);
                mostrarMensaje("Auto Actualizado");
            }

        });
    }

    private void capturarDatos(){
        String placa = txtPlaca.getText().toString();
        String marca = txtMarca.getText().toString();
        String modelo = txtModelo.getText().toString();
        String anio = txtAnio.getText().toString();
        if(registra){
            car = new Car(UUID.randomUUID().toString(),placa,marca,modelo,anio,"test");
        }else {
            map.put("placa",placa);
            map.put("marca",marca);
            map.put("modelo",modelo);
            map.put("anio",anio);
        }
    }

    private void mostrarMensaje(String mensaje){
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setTitle("Mensaje Informativo");
        ventana.setMessage(mensaje);
        ventana.setPositiveButton("ACEPTAR",((dialogInterface, i) -> {
            finish();
        }));
        ventana.create().show();
    }

    private void verificarModificar(){
        if(getIntent().hasExtra("p_id")){
            registra = false;
            id = getIntent().getStringExtra("p_id");
            txtPlaca.setText(getIntent().getStringExtra("p_placa"));
            txtMarca.setText(getIntent().getStringExtra("p_marca"));
            txtModelo.setText(getIntent().getStringExtra("p_modelo"));
            txtAnio.setText(getIntent().getStringExtra("p_anio"));
            btnRegistrar.setText("ACTUALIZAR VEHÍCULO");
            titulo.setText("ACTUALIZAR VEHÍCULO");
        }
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        database=FirebaseDatabase.getInstance();
        reference = database.getReference();

    }
}