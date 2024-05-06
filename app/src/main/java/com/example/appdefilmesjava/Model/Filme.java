package com.example.appdefilmesjava.Model;

public class Filme {

    private String titulo;
    private String capa;
    private String descricao;
    private String elenco;
    private String video;

    public Filme(String titulo, String capa, String descricao, String elenco) {
        this.titulo = titulo;
        this.capa = capa;
        this.descricao = descricao;
        this.elenco = elenco;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getCapa() {
        return capa;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getElenco() {
        return elenco;
    }
    public String getVideo() {
        return video;
    }

}
