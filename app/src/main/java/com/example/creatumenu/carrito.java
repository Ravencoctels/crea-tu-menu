package com.example.creatumenu;

import java.util.ArrayList;
import java.util.List;

public class carrito {
    private List<String> items;

    public carrito() {
        items = new ArrayList<>();
    }

    public void agregarItem(String item) {
        items.add(item);
    }

    public void eliminarItem(int indice) {
        if (indice >= 0 && indice < items.size()) {
            items.remove(indice);
        }
    }
    public List<String> getItems() {
        return items;
    }

    public void vaciarCarrito() {
        items.clear();
    }
}