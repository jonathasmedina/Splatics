package com.example.jonathas.splatics;

import java.io.Serializable;

public class Jogador implements Serializable{
    String nick;
    String level;
    boolean aliado;
    Roupa roupa;
    int ktdKills;
    int ktdDeaths;
    Arma arma;

    public Arma getArma() {
        return arma;
    }

    public Jogador() {
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isAliado() {
        return aliado;
    }

    public void setAliado(boolean aliado) {
        this.aliado = aliado;
    }

    public Roupa getRoupa() {
        return roupa;
    }

    public void setRoupa(Roupa roupa) {
        this.roupa = roupa;
    }

    public int getKtdKills() {
        return ktdKills;
    }

    public void setKtdKills(int ktdKills) {
        this.ktdKills = ktdKills;
    }

    public int getKtdDeaths() {
        return ktdDeaths;
    }

    public void setKtdDeaths(int ktdDeaths) {
        this.ktdDeaths = ktdDeaths;
    }
}
