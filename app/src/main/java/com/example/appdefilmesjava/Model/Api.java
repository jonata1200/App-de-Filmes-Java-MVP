package com.example.appdefilmesjava.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("filmes.json?alt=media&token=8435b463-eec0-49de-9142-d83140e1f9bc")
    Call<List<Filme>> getFilme();

}
