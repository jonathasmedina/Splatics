package com.example.jonathas.splatics;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Partida implements Serializable {
    String id;

    public Partida() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String fase;
    String modo;
    ArrayList<Jogador> jogadores = new ArrayList<>();
    boolean vitoria;

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public boolean isVitoria() {
        return vitoria;
    }

    public void setVitoria(boolean vitoria) {
        this.vitoria = vitoria;
    }
}
