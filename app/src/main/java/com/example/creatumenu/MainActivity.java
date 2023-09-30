package com.example.creatumenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView hamburgesasRecyclerView;
    private RecyclerView pizzasRecyclerView;
    private RecyclerView bebidasRecyclerView;
    private adaptador hamburgesasAdapter;
    private adaptador pizzasAdapter;
    private adaptador bebidasAdapter;
    private carrito carrito;
    private TextView carritoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hamburgesasRecyclerView = findViewById(R.id.hamburgesas);
        pizzasRecyclerView = findViewById(R.id.pizzas);
        bebidasRecyclerView = findViewById(R.id.bebidas);
        carritoTextView = findViewById(R.id.carritoTextView);

        carrito = new carrito();

        hamburgesasAdapter = new adaptador(this, new adaptador.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                lista_elementos item = hamburgesasAdapter.getItemList().get(position);
                String itemInfo = item.getNombre() + " - $" + item.getPrecio();
                carrito.agregarItem(itemInfo);
                actualizarCarritoTextView();
                Toast.makeText(MainActivity.this, "Añadido al carrito: " + itemInfo, Toast.LENGTH_SHORT).show();
            }
        });

        pizzasAdapter = new adaptador(this, new adaptador.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                lista_elementos item = pizzasAdapter.getItemList().get(position);
                String itemInfo = item.getNombre() + " - $" + item.getPrecio();
                carrito.agregarItem(itemInfo);
                actualizarCarritoTextView();
                Toast.makeText(MainActivity.this, "Añadido al carrito: " + itemInfo, Toast.LENGTH_SHORT).show();
            }
        });

        bebidasAdapter =new adaptador(this, new adaptador.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                lista_elementos item = bebidasAdapter.getItemList().get(position);
                String itemInfo = item.getNombre() + " - $" + item.getPrecio();
                carrito.agregarItem(itemInfo);
                actualizarCarritoTextView();
                Toast.makeText(MainActivity.this, "Añadido al carrito: " + itemInfo, Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        hamburgesasRecyclerView.setAdapter(hamburgesasAdapter);
        hamburgesasRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        pizzasRecyclerView.setAdapter(pizzasAdapter);
        pizzasRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        bebidasRecyclerView.setAdapter(bebidasAdapter);
        bebidasRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<lista_elementos> dataHamburguesas = getHamburguesasData();
        hamburgesasAdapter.setData(dataHamburguesas);

        List<lista_elementos> dataPizzas = getPizzasData();
        pizzasAdapter.setData(dataPizzas);

        List<lista_elementos> dataBebidas = getBebidasData();
        bebidasAdapter.setData(dataBebidas);
    }

    private void actualizarCarritoTextView() {
        List<String> itemsEnCarrito = carrito.getItems();
        int precioTotal = 0;

        for (String item : itemsEnCarrito) {
            String[] partes = item.split(" ");
            if (partes.length > 0) {
                try {
                    int precioItem = Integer.parseInt(partes[partes.length - 1].replace("$", ""));
                    precioTotal += precioItem;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }

        carritoTextView.setText("Precio Total: $" + precioTotal);
    }

    public List<lista_elementos> getHamburguesasData() {
        List<lista_elementos> list = new ArrayList<>();
        list.add(new lista_elementos(R.drawable.burger, "Hamburguesa Clásica", "Carne de res molida, Lechuga, Tomate, Cebolla, Queso cheddar, Pan de hamburguesa", 8000));
        list.add(new lista_elementos(R.drawable.bbq, "Hamburguesa BBQ", "Carne de res molida, Salsa barbacoa, Cebolla caramelizada, Queso suizo, Pan de hamburguesa", 8500));
        list.add(new lista_elementos(R.drawable.vegetariana, "Hamburguesa Vegetariana", "Hamburguesa de garbanzos o soja, Lechuga, Tomate, Cebolla morada, Pan de hamburguesa integral", 9000));
        return list;
    }

    public List<lista_elementos> getPizzasData() {
        List<lista_elementos> list = new ArrayList<>();
        list.add(new lista_elementos(R.drawable.margarita, "Pizza Margarita", "Salsa de tomate, Mozzarella, Albahaca fresca", 12000));
        list.add(new lista_elementos(R.drawable.pepperoni, "Pizza Pepperoni", "Salsa de tomate, Mozzarella, Pepperoni, Pimientos", 13000));
        list.add(new lista_elementos(R.drawable.hawaiana, "Pizza Hawaiana", "Salsa de tomate, Mozzarella, Jamón, Piña", 14000));

        return list;
    }

    public List<lista_elementos> getBebidasData() {
        List<lista_elementos> list = new ArrayList<>();
        list.add(new lista_elementos(R.drawable.coca, "Coca-Cola", "Refresco carbonatado", 2500));
        list.add(new lista_elementos(R.drawable.agua, "Agua Mineral", "Agua natural sin gas", 1500));
        list.add(new lista_elementos(R.drawable.naranja, "Jugo de Naranja", "Jugo de naranja fresco", 2000));

        return list;
    }
}
