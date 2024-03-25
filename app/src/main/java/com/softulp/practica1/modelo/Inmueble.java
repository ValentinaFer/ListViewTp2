package com.softulp.practica1.modelo;

public class Inmueble {
    private int img;
    private String localidad;
    private double precio;

    public Inmueble(int img, String localidad, double precio) {
        this.img = img;
        this.localidad = localidad;
        this.precio = precio;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
