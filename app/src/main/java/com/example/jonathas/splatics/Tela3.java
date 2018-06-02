package com.example.jonathas.splatics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Tela3 extends AppCompatActivity {

    Spinner spinnerJogadores;
    String jogadorSelecionado = "";
    int posicaoJogSelec;
    Button salvarBt;
    EditText qtdKills;
    EditText qtdDeaths;
    RadioGroup vitDer;
    RadioGroup aliadInim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        spinnerJogadores = findViewById(R.id.spinner6);
        salvarBt = findViewById(R.id.button5);
        qtdKills = findViewById(R.id.editText);
        qtdDeaths = findViewById(R.id.editText2);
        vitDer = findViewById(R.id.radioGroup2);
        aliadInim = findViewById(R.id.radioGroup);

        Intent intent = getIntent();
        final Partida partida = (Partida) intent.getSerializableExtra("partida");

        List<String> jogadoresNomes = new ArrayList<>();
        for (Jogador j: partida.getJogadores()){
            String nome = j.getNick();
            jogadoresNomes.add(nome);

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Tela3.this,
                android.R.layout.simple_spinner_item,jogadoresNomes);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJogadores.setAdapter(adapter);
        spinnerJogadores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                jogadorSelecionado = (String) parent.getItemAtPosition(position);
                posicaoJogSelec = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        salvarBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qtdKills_ = Integer.parseInt(qtdKills.getText().toString());
                int qtdDeaths_ = Integer.parseInt(qtdDeaths.getText().toString());

                partida.getJogadores().get(posicaoJogSelec).setKtdKills(qtdKills_);
                partida.getJogadores().get(posicaoJogSelec).setKtdDeaths(qtdDeaths_);

                switch (vitDer.getCheckedRadioButtonId()) {
                    case R.id.radioButton6:
                        partida.setVitoria(true);
                        break;
                    case R.id.radioButton7:
                        partida.setVitoria(false);
                        break;
                }

                switch (aliadInim.getCheckedRadioButtonId()) {
                    case R.id.radioButton8:
                        partida.getJogadores().get(posicaoJogSelec).setAliado(false);
                        break;
                    case R.id.radioButton9:
                        partida.getJogadores().get(posicaoJogSelec).setAliado(true);
                        break;
                }

            }

            });


        }
}
