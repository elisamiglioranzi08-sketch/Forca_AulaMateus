package com.example.forca_integrado;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adaptador extends RecyclerView.Adapter<RecyHolder> {

    private Arraylist<Palavra> lista;

    @NonNull
    @Override
    public RecyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false );
        return new RecyHolder(view);
    }

    public Adaptador(Arraylist<Palavra> lista){
        this.lista = lista;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyHolder holder, int position) {
        holder.txtPalavra.setText(lista.get(position).getPalavraDigitada());
        holder.txtCategoria.setText(lista.get(position).getCategoria());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
