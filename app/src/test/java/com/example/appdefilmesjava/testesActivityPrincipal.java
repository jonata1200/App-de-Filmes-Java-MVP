package com.example.appdefilmesjava;

import static org.junit.Assert.assertEquals;

import com.example.appdefilmesjava.Model.Api;
import com.example.appdefilmesjava.Model.Filme;
import com.example.appdefilmesjava.ui.ActivityPrincipal.ActivityPrincipalContrato;
import com.example.appdefilmesjava.ui.ActivityPrincipal.ActivityPrincipalPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

public class testesActivityPrincipal {

    @Mock
    ActivityPrincipalContrato.View view;

    @Mock
    ActivityPrincipalContrato.Presenter presenter;

    @Mock
    Api api;

    ArrayList<Filme> listaFilmes = new ArrayList<>();


    @Before
    public void Inicializacao_Classes(){
        MockitoAnnotations.openMocks(this);
                presenter = new ActivityPrincipalPresenter(view, api);
    }


    @Test
    public void testando_Toast_Filmes(){
        view.showError("Erro percebido");
        Mockito.verify(view).showError("Erro percebido");
    }


    @Test
    public void Itens_Lista_Filmes(){
        listaFilmes.add(new Filme("Star Wars", "mmmm", "Guerra nas Estrelas", "Luke Skywalker"));
        listaFilmes.add(new Filme("Velozes e Furiosos", "cccc", "Corrida", "Vin Diesel"));
        listaFilmes.add(new Filme("Mutantes", "kkkk", "Ficção", "ET Bilu"));

        assertEquals(listaFilmes.get(2).getCapa(), "kkkk");
    }

    @Test
    public void Tamanho_Lista_Filmes(){
        listaFilmes.add(new Filme("Star Wars", "mmmm", "Guerra nas Estrelas", "Luke Skywalker"));
        listaFilmes.add(new Filme("Velozes e Furiosos", "cccc", "Corrida", "Vin Diesel"));

        if (listaFilmes.isEmpty()){
            System.out.println("Lista Vazia!");
        }else {
            for (int indice = 0; indice <= listaFilmes.size()-1; indice++){
                System.out.println(listaFilmes.get(indice).getTitulo() + " ");
                System.out.println(listaFilmes.get(indice).getCapa() + " ");
                System.out.println(listaFilmes.get(indice).getDescricao() + " ");
                System.out.println(listaFilmes.get(indice).getElenco() + " \n");
            }
        }

        assertEquals(listaFilmes.size(), 2);
    }

}
