package com.example.creatumenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class adaptador extends RecyclerView.Adapter<adaptador.ItemViewHolder> {

    private List<lista_elementos> itemList;
    private Context context;

    public adaptador(Context context) {
        this.context = context;
        this.itemList = new ArrayList<>(); // Inicializa la lista vacía
    }

    public void setData(List<lista_elementos> itemList) {
        this.itemList.clear(); // Borra los elementos existentes
        this.itemList.addAll(itemList); // Agrega los nuevos elementos
        notifyDataSetChanged(); // Notifica que los datos han cambiado
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lista_elementos, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        lista_elementos item = itemList.get(position);
        holder.ImageButton.setImageResource(item.getImagen());
        holder.textViewNombre.setText(item.getNombre());
        holder.textViewContenido.setText(item.getContenido());
        holder.textViewPrecio.setText("$" + item.getPrecio());
        holder.textViewStock.setText(item.getStock());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageButton ImageButton;
        TextView textViewNombre;
        TextView textViewContenido;
        TextView textViewPrecio;
        TextView textViewStock;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ImageButton = itemView.findViewById(R.id.imagen_list);
            textViewNombre = itemView.findViewById(R.id.nombre_list);
            textViewContenido = itemView.findViewById(R.id.contenido_list);
            textViewPrecio = itemView.findViewById(R.id.precio_list);
            textViewStock = itemView.findViewById(R.id.stock_list);
        }
    }
}
