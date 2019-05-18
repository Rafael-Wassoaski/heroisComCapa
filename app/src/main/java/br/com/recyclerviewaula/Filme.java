package br.com.recyclerviewaula;

import java.io.Serializable;

public class Filme implements Serializable {

    private String titulo;
    private String genero;
    private int ano;
    private String capa;

    public Filme() {
    }

    public Filme(String titulo, String genero, int ano, String capa) {
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
        this.capa = capa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCapa(String capa){ this.capa = capa;}

    public String getCapa(){return capa;}
}
