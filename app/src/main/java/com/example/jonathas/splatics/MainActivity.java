package com.example.jonathas.splatics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    Button bt;
    Spinner spinner;
    String faseSelecionada;
    String modoSelecionado;
    RadioGroup radioGroupModo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] MODOS = new String[] {"Rainmaker", "Splatzone", "Clam Blitz", "Tower Control"};

        bt = (Button) findViewById(R.id.button2);
        radioGroupModo = findViewById(R.id.radioGroup);


        //ouvinte spinner
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,Fases.FASES);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                faseSelecionada = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (radioGroupModo.getCheckedRadioButtonId()){
                    case R.id.radioButton:
                        modoSelecionado = "Turf War";
                        break;
                    case R.id.radioButton2:
                        modoSelecionado = "Rainmaker";
                        break;
                    case R.id.radioButton3:
                        modoSelecionado = "Splat Zones";
                        break;
                    case R.id.radioButton4:
                        modoSelecionado = "Clam Blitz";
                        break;
                    case R.id.radioButton5:
                        modoSelecionado = "Tower Control";
                        break;
                }
                Partida partida = new Partida();

                partida.setId(UUID.randomUUID().toString());
                partida.setModo(modoSelecionado);
                partida.setFase(faseSelecionada);


                Intent intent = new Intent(MainActivity.this, Tela2.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("partida", partida);
                intent.putExtras(bundle);

                startActivity(intent);
                finish();
            }
        });

    }

}
