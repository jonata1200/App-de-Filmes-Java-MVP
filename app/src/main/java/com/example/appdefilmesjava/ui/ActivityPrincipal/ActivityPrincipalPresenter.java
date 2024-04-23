package com.example.appdefilmesjava.ui.ActivityPrincipal;


import androidx.annotation.NonNull;

import com.example.appdefilmesjava.Model.Api;
import com.example.appdefilmesjava.Model.Filme;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityPrincipalPresenter implements ActivityPrincipalContrato.Presenter {

    private final ActivityPrincipalContrato.View view;
    private final Api filmesApi;

    public ActivityPrincipalPresenter(ActivityPrincipalContrato.View view, Api filmesApi) {
        this.view = view;
        this.filmesApi = filmesApi;
    }

    @Override
    public void getFilmes() {

        Call<List<Filme>> call = filmesApi.getFilme();
        call.enqueue(new Callback<List<Filme>>() {
            @Override
            public void onResponse(@NonNull Call<List<Filme>> call, @NonNull Response<List<Filme>> response) {
                if (response.code() != 200){
                    return;
                }
                List<Filme> filmes = response.body();

                assert filmes != null;
                view.showFilmes(filmes);
            }

            @Override
            public void onFailure(@NonNull Call<List<Filme>> call, @NonNull Throwable t) {
                view.showError();
            }
        });
    }
}
