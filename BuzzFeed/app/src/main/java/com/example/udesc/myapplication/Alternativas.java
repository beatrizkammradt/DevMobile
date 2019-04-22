package com.example.udesc.myapplication;

public class Alternativas {
    private int indice;
    private String texto;

    public Alternativas(int indice, String texto){
        this.indice = indice;
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public int getIndice() {
        return indice;
    }
}
