package com.example.creatumenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView hamburgesas;
    private RecyclerView pizzas;
    private RecyclerView bebidas;
    private adaptador hamburgesasAdapter;
    private adaptador pizzasAdapter;
    private adaptador bebidasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hamburgesas = findViewById(R.id.hamburgesas);
        pizzas = findViewById(R.id.pizzas);
        bebidas = findViewById(R.id.bebidas);


        hamburgesasAdapter = new adaptador(this);
        pizzasAdapter = new adaptador(this);
        bebidasAdapter = new adaptador(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);


        hamburgesas.setAdapter(hamburgesasAdapter);
        hamburgesas.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        pizzas.setAdapter(pizzasAdapter);
        pizzas.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        bebidas.setAdapter(bebidasAdapter);
        bebidas.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        List<lista_elementos> dataHamburguesas = getHamburguesasData();
        hamburgesasAdapter.setData(dataHamburguesas);

        List<lista_elementos> dataPizzas = getPizzasData();
        pizzasAdapter.setData(dataPizzas);

        List<lista_elementos> dataBebidas = getBebidasData();
        bebidasAdapter.setData(dataBebidas);
    }

    public List<lista_elementos> getHamburguesasData() {
        List<lista_elementos> list = new ArrayList<>();
        list.add(new lista_elementos(R.drawable.burger, "Hamburguesa Clásica", "Carne de res molida, Lechuga, Tomate, Cebolla, Queso cheddar, Pan de hamburguesa", 8000, "hay stock"));
        list.add(new lista_elementos(R.drawable.burger, "Hamburguesa BBQ", "Carne de res molida, Salsa barbacoa, Cebolla caramelizada, Queso suizo, Pan de hamburguesa", 8500, "No hay stock"));
        list.add(new lista_elementos(R.drawable.burger, "Hamburguesa Vegetariana", "Hamburguesa de garbanzos o soja, Lechuga, Tomate, Cebolla morada, Pan de hamburguesa integral", 9000, "hay stock"));
        list.add(new lista_elementos(R.drawable.burger, "Hamburguesa Vegetariana", "Hamburguesa de garbanzos o soja, Lechuga, Tomate, Cebolla morada, Pan de hamburguesa integral", 9000, "no hay stock"));
        return list;
    }

    public List<lista_elementos> getPizzasData() {
        List<lista_elementos> list = new ArrayList<>();
        list.add(new lista_elementos(R.drawable.pizza, "Pizza Margherita", "Tomato, Mozzarella, Basil", 10000, "hay stock"));
        list.add(new lista_elementos(R.drawable.pizza, "Pizza Pepperoni", "Pepperoni, Tomato sauce, Mozzarella", 12000, "hay stock"));
        return list;
    }

    public List<lista_elementos> getBebidasData() {
        List<lista_elementos> list = new ArrayList<>();
        list.add(new lista_elementos(R.drawable.coca, "Coca-Cola", "330ml can", 2000, "hay stock"));
        list.add(new lista_elementos(R.drawable.coca, "Sprite", "330ml can", 2000, "hay stock"));
        return list;
    }
}
