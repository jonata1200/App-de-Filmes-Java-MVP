package com.example.appdefilmesjava.ui.DetalhesFilme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appdefilmesjava.R;
import com.example.appdefilmesjava.databinding.ActivityDetalhesFilmeBinding;
import com.example.appdefilmesjava.ui.Video.Video;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetalhesFilme extends AppCompatActivity {

    private ActivityDetalhesFilmeBinding binding;

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


        String capa = getIntent().getExtras().getString("capa");
        String titulo = getIntent().getExtras().getString("titulo");
        String descricao = getIntent().getExtras().getString("descricao");
        String elenco = getIntent().getExtras().getString("elenco");
        String video = getIntent().getExtras().getString("video");

        Glide.with(this).load(capa).into(binding.DtCapaFilme);
        binding.DtNomeFilme.setText(titulo);
        binding.DtDetalheFilme.setText(descricao);
        binding.DtElencoFilme.setText(elenco);

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

}