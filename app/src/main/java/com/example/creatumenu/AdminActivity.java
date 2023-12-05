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

        // Inicializa la base de datos de Firebase
        inicializarBB();

        // Referencias a los elementos de la interfaz de usuario
        nombreProductoEditText = findViewById(R.id.nombreProductoEditText);
        descripcionProductoEditText = findViewById(R.id.descripcionProductoEditText);
        precioProductoEditText = findViewById(R.id.precioProductoEditText);
        agregarProductoButton = findViewById(R.id.agregarProductoButton);

        // Listener para el botón de agregar producto
        agregarProductoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNuevoProducto();
            }
        });
    }

    private void inicializarBB() {
        // Inicializa Firebase
        FirebaseApp.initializeApp(this);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference("productos"); // Cambia "productos" por el nombre de tu nodo
    }

    private void agregarNuevoProducto() {
        // Obtiene los valores ingresados por el administrador
        String nombre = nombreProductoEditText.getText().toString().trim();
        String descripcion = descripcionProductoEditText.getText().toString().trim();
        int precio = Integer.parseInt(precioProductoEditText.getText().toString().trim());

        // Crea un objeto Producto
        Producto nuevoProducto = new Producto(nombre, descripcion, precio);

        // Agrega el nuevo producto a la base de datos de Firebase
        String key = databaseReference.push().getKey();
        databaseReference.child(key).setValue(nuevoProducto);

        // Muestra un mensaje al administrador
        Toast.makeText(this, "Producto agregado exitosamente", Toast.LENGTH_SHORT).show();

        // Limpia los campos de entrada después de agregar el producto
        nombreProductoEditText.setText("");
        descripcionProductoEditText.setText("");
        precioProductoEditText.setText("");
    }
}
