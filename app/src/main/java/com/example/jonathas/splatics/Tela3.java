package com.example.jonathas.splatics;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
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

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    Button salvarCadOutroBt;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


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
        salvarCadOutroBt = findViewById(R.id.button3);


        inicializarFirebase();

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

        salvarCadOutroBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO mudar de tela carregando os dados do jogador já cadastrado
                Intent intent = new Intent(Tela3.this, Tela2.class);
              /*  Bundle bundle = new Bundle();
                bundle.putSerializable("partida", partida);
                intent.putExtras(bundle);*/
                startActivity(intent);
            }
        });


        salvarBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(qtdDeaths.getText().toString().trim().length() == 0)
                    qtdDeaths.setError("Preencha o campo");
                else if (qtdKills.getText().toString().trim().length() == 0){
                    qtdKills.setError("Preencha o campo");
                }
                else{
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

                    //inserção
                    databaseReference.child("Partida").child(partida.getId()).setValue(partida);
                    Intent intent = new Intent(Tela3.this, MainActivity.class);
                    alert(intent);


                }
            }
        });

    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(Tela3.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    private void alert(final Intent intent){
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle("Cadastro efetuado!")
                .setMessage("Dados salvos no banco")
                .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(intent);
                        finish();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert).show();

    }

}
