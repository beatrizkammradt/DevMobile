package com.example.udesc.myapplication;

public class Pergunta {
    private int indice;
    private String titulo;
    private Alternativas alt1;
    private Alternativas alt2;
    private Alternativas alt3;


    public Pergunta(int indice, String titulo, Alternativas alt1, Alternativas alt2, Alternativas alt3) {
        this.indice = indice;
        this.titulo = titulo;
        this.alt1 = alt1;
        this.alt2 = alt2;
        this.alt3 = alt3;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getIndice() {
        return indice;
    }
}
