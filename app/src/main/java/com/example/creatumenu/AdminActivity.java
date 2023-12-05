package com.example.creatumenu;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.FirebaseApp;

public class AdminActivity extends AppCompatActivity {

    private EditText nombreProductoEditText;
    private EditText descripcionProductoEditText;
    private EditText precioProductoEditText;
    private Button agregarProductoButton;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        inicializarBB();

        nombreProductoEditText = findViewById(R.id.nombreProductoEditText);
        descripcionProductoEditText = findViewById(R.id.descripcionProductoEditText);
        precioProductoEditText = findViewById(R.id.precioProductoEditText);
        agregarProductoButton = findViewById(R.id.agregarProductoButton);

        agregarProductoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNuevoProducto();
            }
        });
    }

    private void inicializarBB() {

        FirebaseApp.initializeApp(this);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference("productos");
    }

    private void agregarNuevoProducto() {

        String nombre = nombreProductoEditText.getText().toString().trim();
        String descripcion = descripcionProductoEditText.getText().toString().trim();
        int precio = Integer.parseInt(precioProductoEditText.getText().toString().trim());


        Producto nuevoProducto = new Producto(nombre, descripcion, precio);


        String key = databaseReference.push().getKey();
        databaseReference.child(key).setValue(nuevoProducto);


        Toast.makeText(this, "Producto agregado exitosamente", Toast.LENGTH_SHORT).show();


        nombreProductoEditText.setText("");
        descripcionProductoEditText.setText("");
        precioProductoEditText.setText("");
    }
}
