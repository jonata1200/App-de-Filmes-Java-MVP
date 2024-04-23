package com.example.appdefilmesjava.ui.ActivityPrincipal;

import com.example.appdefilmesjava.Model.Filme;

import java.util.List;

public interface ActivityPrincipalContrato {

    interface View{
        void showFilmes(List<Filme> filmes);
        void showError();
    }

    interface Presenter{
        void getFilmes();
    }
}
