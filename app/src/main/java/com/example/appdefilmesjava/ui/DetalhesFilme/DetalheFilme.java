package com.example.appdefilmesjava.ui.DetalhesFilme;

import android.widget.ImageView;
import android.widget.TextView;

public interface DetalheFilme {

    interface View{
        DetalhesFilme getContext();
        ImageView getDtCapaFilme();
        TextView getDtNomeFilme();
        TextView getDtDetalheFilme();
        TextView getDtElencoFilme();
    }

    interface Presenter{
        void loadFilmeDetails(String capa, String titulo, String descricao, String elenco, String video);
    }
}
