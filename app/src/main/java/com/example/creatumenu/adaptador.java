package com.example.creatumenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class adaptador extends RecyclerView.Adapter<adaptador.ItemViewHolder> {

    private List<lista_elementos> itemList;
    private Context context;
    private OnItemClickListener listener;

    public adaptador(Context context, OnItemClickListener listener) {
        this.context = context;
        this.itemList = new ArrayList<>();
        this.listener = listener;
    }

    public void setData(List<lista_elementos> itemList) {
        this.itemList.clear();
        this.itemList.addAll(itemList);
        notifyDataSetChanged();
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
        holder.imageButton.setImageResource(item.getImagen());
        holder.textViewNombre.setText(item.getNombre());
        holder.textViewContenido.setText(item.getContenido());
        holder.textViewPrecio.setText("$" + item.getPrecio());

        holder.buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public List<lista_elementos> getItemList() {
        return itemList;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageButton imageButton;
        TextView textViewNombre;
        TextView textViewContenido;
        TextView textViewPrecio;
        Button buttonAgregar;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.imagen_list);
            textViewNombre = itemView.findViewById(R.id.nombre_list);
            textViewContenido = itemView.findViewById(R.id.contenido_list);
            textViewPrecio = itemView.findViewById(R.id.precio_list);
            buttonAgregar = itemView.findViewById(R.id.agregar_list);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}