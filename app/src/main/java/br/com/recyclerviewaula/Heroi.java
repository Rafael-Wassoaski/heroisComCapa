package br.com.recyclerviewaula;

import java.io.Serializable;

public class Heroi implements Serializable {

    private String nomeHeroi;
    private String poder;
    private String nome;
    private String capa;

    public Heroi() {
    }

    public Heroi(String nomeHeroi, String genero, int ano, String capa) {
        this.nomeHeroi = nomeHeroi;
        this.nome = nome;
        this.poder = poder;
        this.capa = capa;
    }

    public String getNomeHeroi() {
        return nomeHeroi;
    }

    public void setNomeHeroi(String NomeHeroi) {
        this.nomeHeroi = nomeHeroi;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCapa(String capa){ this.capa = capa;}

    public String getCapa(){return capa;}
}
