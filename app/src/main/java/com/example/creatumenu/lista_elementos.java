package com.example.creatumenu;

import android.graphics.drawable.Drawable;

public class lista_elementos {
    public int imagen;
    public String nombre;
    public String contenido;
    public int precio;
    public String stock;

    public lista_elementos(int imagen, String nombre, String contenido, int precio, String stock) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.contenido = contenido;
        this.precio = precio;
        this.stock = stock;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}