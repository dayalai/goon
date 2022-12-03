package com.example.goon.models;

public class Car {
    private String uid;
    private String placa;
    private  String marca;
    private String modelo;
    private String anio;
    private String driveruid;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getDriveruid() {
        return driveruid;
    }

    public void setDriveruid(String driveruid) {
        this.driveruid = driveruid;
    }

    public Car(String uid, String placa, String marca, String modelo, String anio, String driveruid) {
        this.uid = uid;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.driveruid = driveruid;
    }
    public Car(){

    }
}
