package com.example.forca_integrado;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyHolder extends RecyclerView.ViewHolder {

    protected TextView txtPalavra, txtCategoria;

    public RecyHolder(@NonNull View itemView) {
        super(itemView);
        txtPalavra = itemView.findViewById(R.id_palavra);
        txtCategoria = itemView.findViewById(R.id_categoria);
    }
}
