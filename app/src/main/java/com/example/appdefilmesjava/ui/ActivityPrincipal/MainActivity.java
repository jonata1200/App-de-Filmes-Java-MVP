package com.example.appdefilmesjava.ui.ActivityPrincipal;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.appdefilmesjava.Adapter.Adapter;
import com.example.appdefilmesjava.Model.Api;
import com.example.appdefilmesjava.Model.Filme;
import com.example.appdefilmesjava.R;
import com.example.appdefilmesjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements ActivityPrincipalContrato.View {

    private ActivityMainBinding binding;
    private ActivityPrincipalPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://firebasestorage.googleapis.com/v0/b/app-delivery-97d5b.appspot.com/o/")
                .build();

        Api filmeApi = retrofit.create(Api.class);
        presenter = new ActivityPrincipalPresenter(this, filmeApi);
        presenter.getFilmes();
    }

    @Override
    public void showFilmes(List<Filme> filmes) {
        binding.RecyclerFilmes.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        binding.RecyclerFilmes.setHasFixedSize(true);
        Adapter adapter = new Adapter(filmes, MainActivity.this);
        binding.RecyclerFilmes.setAdapter(adapter);
    }

    @Override
    public void showError(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}