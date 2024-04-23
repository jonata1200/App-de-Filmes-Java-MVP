package com.example.appdefilmesjava.ui.DetalhesFilme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdefilmesjava.R;
import com.example.appdefilmesjava.databinding.ActivityDetalhesFilmeBinding;
import com.example.appdefilmesjava.ui.Video.Video;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetalhesFilme extends AppCompatActivity implements DetalheFilme.View {

    private ActivityDetalhesFilmeBinding binding;
    private DetalhesFilmePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityDetalhesFilmeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        presenter = new DetalhesFilmePresenter(this);

        String capa = getIntent().getExtras().getString("capa");
        String titulo = getIntent().getExtras().getString("titulo");
        String descricao = getIntent().getExtras().getString("descricao");
        String elenco = getIntent().getExtras().getString("elenco");
        String video = getIntent().getExtras().getString("video");

        presenter.loadFilmeDetails(capa, titulo, descricao, elenco, video);

        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.DtPlayFilme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalhesFilme.this, Video.class);
                intent.putExtra("video", video);
                startActivity(intent);
            }
        });
    }


    @Override
    public DetalhesFilme getContext() {
        return this;
    }

    @Override
    public ImageView getDtCapaFilme() {
        return binding.DtCapaFilme;
    }

    @Override
    public TextView getDtNomeFilme() {
        return binding.DtNomeFilme;
    }

    @Override
    public TextView getDtDetalheFilme() {
        return binding.DtDetalheFilme;
    }

    @Override
    public TextView getDtElencoFilme() {
        return binding.DtElencoFilme;
    }

}