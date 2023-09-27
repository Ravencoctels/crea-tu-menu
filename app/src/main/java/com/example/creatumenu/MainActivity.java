package com.example.creatumenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView lista;
    private adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        adaptador = new adaptador(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lista.setLayoutManager(linearLayoutManager);
        lista.setAdapter(adaptador);

        // Obtén la lista de datos y establece los datos en el adaptador
        List<lista_elementos> data = getData();
        adaptador.setData(data);
    }

    public List<lista_elementos> getData() {
        List<lista_elementos> list = new ArrayList<>();
        list.add(new lista_elementos(R.drawable.burger, "Hamburguesa Clásica", "Carne de res molida, Lechuga, Tomate, Cebolla, Queso cheddar, Pan de hamburguesa", 8000, "hay stock"));
        list.add(new lista_elementos(R.drawable.burger, "Hamburguesa BBQ", "Carne de res molida, Salsa barbacoa, Cebolla caramelizada, Queso suizo, Pan de hamburguesa", 8500, "No hay stock"));
        list.add(new lista_elementos(R.drawable.burger, "Hamburguesa Vegetariana", "Hamburguesa de garbanzos o soja, Lechuga, Tomate, Cebolla morada, Pan de hamburguesa integral", 9000, "hay stock"));
        list.add(new lista_elementos(R.drawable.burger, "Hamburguesa Vegetariana", "Hamburguesa de garbanzos o soja, Lechuga, Tomate, Cebolla morada, Pan de hamburguesa integral", 9000, "no hay stock"));
        return list;
    }
}
