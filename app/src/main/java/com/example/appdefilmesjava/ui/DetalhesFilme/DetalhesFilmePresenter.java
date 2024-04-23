package com.example.appdefilmesjava.ui.DetalhesFilme;

import com.bumptech.glide.Glide;

public class DetalhesFilmePresenter implements DetalheFilme.Presenter {

    private final DetalhesFilme view;

    public DetalhesFilmePresenter(DetalhesFilme view) {
        this.view = view;
    }

    public void loadFilmeDetails(String capa, String titulo, String descricao, String elenco, String video) {
        Glide.with(view.getContext()).load(capa).into(view.getDtCapaFilme());
        view.getDtNomeFilme().setText(titulo);
        view.getDtDetalheFilme().setText(descricao);
        view.getDtElencoFilme().setText(elenco);
    }
}
