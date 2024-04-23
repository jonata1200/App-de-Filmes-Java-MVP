package com.example.appdefilmesjava.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appdefilmesjava.Model.Filme;
import com.example.appdefilmesjava.databinding.ItemFilmeBinding;
import com.example.appdefilmesjava.ui.DetalhesFilme.DetalhesFilme;


import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.FilmeViewHolder> {

    private Context context;
    private final List<Filme> filmeList;

    public Adapter(List<Filme> filmeList, Context context) {
        this.filmeList = filmeList;
        this.context = context;
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FilmeViewHolder(
                ItemFilmeBinding.inflate(LayoutInflater.from(context), parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Glide.with(context).load(filmeList.get(position).getCapa()).into(holder.binding.capaFilme);
        holder.binding.tituloFilme.setText(filmeList.get(position).getTitulo());

        holder.binding.capaFilme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, DetalhesFilme.class);
                intent.putExtra("capa", filmeList.get(position).getCapa());
                intent.putExtra("titulo", filmeList.get(position).getTitulo());
                intent.putExtra("descricao", filmeList.get(position).getDescricao());
                intent.putExtra("elenco", filmeList.get(position).getElenco());
                intent.putExtra("video", filmeList.get(position).getVideo());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return filmeList.size();
    }

    public static class FilmeViewHolder extends RecyclerView.ViewHolder{

        private final ItemFilmeBinding binding;

        public FilmeViewHolder(@NonNull ItemFilmeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}