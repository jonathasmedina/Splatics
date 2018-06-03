package com.example.jonathas.splatics;

import android.content.Intent;
import android.provider.Telephony;
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tela2 extends AppCompatActivity implements Serializable {

    Button recDadosBt;

    Button salvarProxTelaBt;
    EditText nick;
    String selecionado = "";
    String rankeSelecionado = "";
    String spinnerVal = "";
    String armaSelecionada = "";
    int armaSelecPos;
    int rankPosSelecionado;
    static final String[] dadosRank = new String[] {"X", "S+0 a S+9", "S", "A- a A+", "B- a B+", "C- a C+"};
    static final String[] dadosAbilities = new String[] {"-", "Bomb Defense Up","Cold-Blooded","Comeback","Drop Roller","Haunt","Ink Recovery Up","Ink Resistance Up","Ink Saver (Main)","Ink Saver (Sub)","Last-Ditch Effort","Ninja Squid","Object Shredder","Opening Gambit","Quick Respawn","Quick Super Jump","Respawn Punisher","Run Speed Up","Special Charge Up","Special Power Up","Special Saver","Stealth Jump","Power Up","Swim Speed Up","Tenacity","Thermal Ink"};
    Spinner spinnerRank, spinnerArma, spinnerAbilities1, spinnerAbilities2, spinnerAbilities3, spinnerAbilities4, spinnerAbilities5, spinnerAbilities6, spinnerAbilities7, spinnerAbilities8, spinnerAbilities9, spinnerAbilities10, spinnerAbilities11, spinnerAbilities12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        recDadosBt = findViewById(R.id.button);
        salvarProxTelaBt = findViewById(R.id.button4);
        nick = findViewById(R.id.editText3);
        spinnerArma = findViewById(R.id.spinner2);

        spinnerAbilities1 = findViewById(R.id.spinner3);
        spinnerAbilities2 = findViewById(R.id.spinner4);
        spinnerAbilities3 = findViewById(R.id.spinner5);
        spinnerAbilities4 = findViewById(R.id.spinner7);
        spinnerAbilities5 = findViewById(R.id.spinner10);
        spinnerAbilities6 = findViewById(R.id.spinner11);
        spinnerAbilities7 = findViewById(R.id.spinner12);
        spinnerAbilities8 = findViewById(R.id.spinner13);
        spinnerAbilities9 = findViewById(R.id.spinner14);
        spinnerAbilities10 = findViewById(R.id.spinner15);
        spinnerAbilities11 = findViewById(R.id.spinner16);
        spinnerAbilities12 = findViewById(R.id.spinner9);

       // spinnerShoes = findViewById(R.id.spinner7);
        spinnerRank = findViewById(R.id.spinner8);

        popularSpinnerArma(spinnerArma);
        spinnerArma.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                armaSelecionada = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //TODO popular spinners
        popularSpinnerRank(dadosRank, spinnerRank);

        popularSpinnerAbilities(dadosAbilities, spinnerAbilities1);


        Intent intent = getIntent();
        final Partida partida = (Partida) intent.getSerializableExtra("partida");


        salvarProxTelaBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nick.getText().toString().trim().length() == 0)
                    nick.setError("Preencha o campo");
                else {
                    ArrayList<Jogador> jogadorArrayList = new ArrayList<>();
                    Jogador jogador = new Jogador();
                    jogador.setNick(nick.getText().toString());
                    //TODO implementar level
            //        spinnerVal = valorSelecionadoSpinner(spinnerLevel);
            //        jogador.setLevel(spinnerVal);
                    //spinnerVal = valorSelecionadoSpinner(spinnerArma);
                    Arma arma = new Arma();
                    arma.setNome(armaSelecionada);
                    jogador.setArma(arma);
                    jogadorArrayList.add(jogador);

                    partida.setJogadores(jogadorArrayList);


                    Intent intent = new Intent(Tela2.this, Tela3.class);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("partida", partida);
                    intent.putExtras(bundle);

                    startActivity(intent);
                    finish();
                }
            }
        });




    }

    private void popularSpinnerAbilities(String[] dadosAbilities, Spinner spinnerAbilities1) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Tela2.this,
                android.R.layout.simple_spinner_item,dadosAbilities);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAbilities1.setAdapter(adapter);
        spinnerAbilities2.setAdapter(adapter);
        spinnerAbilities3.setAdapter(adapter);
        spinnerAbilities4.setAdapter(adapter);
        spinnerAbilities5.setAdapter(adapter);
        spinnerAbilities6.setAdapter(adapter);
        spinnerAbilities7.setAdapter(adapter);
        spinnerAbilities8.setAdapter(adapter);
        spinnerAbilities9.setAdapter(adapter);
        spinnerAbilities10.setAdapter(adapter);
        spinnerAbilities11.setAdapter(adapter);
        spinnerAbilities12.setAdapter(adapter);

        spinnerAbilities1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                //habilidade1Selec = (String) parent.getItemAtPosition(position);
                //rankPosSelecionado = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public String valorSelecionadoSpinner(Spinner spinner){

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                selecionado = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return selecionado;

    }



    private void popularSpinnerRank(String[] dadosRank, Spinner spinnerRank) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Tela2.this,
                android.R.layout.simple_spinner_item,dadosRank);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRank.setAdapter(adapter);
        spinnerRank.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                rankeSelecionado = (String) parent.getItemAtPosition(position);
                rankPosSelecionado = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void popularSpinnerArma(Spinner spinner){
        ArrayList<Arma> armaArrayList = new ArrayList<>();
        //coluna 0 = nome da arma; 1 ; 2 e; 3 classe
        String[][] matListArmas = new String[97][4];
        String[] vecListaArmas = new String[]{
                ".52 Gal", " Point Sensor", "Baller", "Shooter", ".52 Gal Deco", "Curling Bomb", "Sting Ray", "Shooter", ".96 Gal", "Sprinkler", "Ink Armor", "Shooter", ".96 Gal Deco", "Splash Wall", "Splashdown", "Shooter", "Aerospray MG", "Suction Bomb", "Curling-Bomb Launcher", "Shooter", "Aerospray RG", "Sprinkler", "  Baller. Baller", "Shooter", "Bamboozler 14 Mk I", "  Curling Bomb. Curling Bomb", "  Tenta Missiles. Tenta Missiles", "Charger", "Blaster", "  Toxic Mist. Toxic Mist", "  Splashdown. Splashdown", "Shooter", "Carbon Roller", "  Autobomb. Autobomb", "  Ink Storm. Ink Storm", "Roller", "Carbon Roller Deco", "  Burst Bomb. Burst Bomb", "  Autobomb Launcher. Autobomb Launcher", "Roller", "Clash Blaster", "  Splat Bomb. Splat Bomb", "  Sting Ray. Sting Ray", "Shooter", "Clash Blaster Neo", "  Curling Bomb. Curling Bomb", "  Tenta Missiles. Tenta Missiles", "Shooter", "Classic Squiffer", "  Point Sensor. Point Sensor", "  Ink Armor. Ink Armor", "Charger", "Custom Blaster", "  Autobomb. Autobomb", "  Inkjet. Inkjet", "Shooter", "Custom Dualie Squelchers", "  Splat Bomb. Splat Bomb", "  Ink Storm. Ink Storm", "Dualie", "Custom E-liter 4K", "  Squid Beakon. Squid Beakon", "  Bubble Blower. Bubble Blower", "Charger", "Custom E-liter 4K Scope", "  Squid Beakon. Squid Beakon", "  Bubble Blower. Bubble Blower", "Charger", "Custom Goo Tuber", "  Curling Bomb. Curling Bomb", "  Inkjet. Inkjet", "Charger", "Custom Jet Squelcher", "  Burst Bomb. Burst Bomb", "  Sting Ray. Sting Ray", "Shooter", "Custom Range Blaster", "  Curling Bomb. Curling Bomb", "  Bubble Blower. Bubble Blower", "Shooter", "Custom Splattershot Jr.", "  Autobomb. Autobomb", "  Ink Storm. Ink Storm", "Shooter", "Dapple Dualies", "  Squid Beakon. Squid Beakon", "  Suction-Bomb Launcher. Suction-Bomb Launcher", "Dualie", "Dapple Dualies Nouveau", "  Toxic Mist. Toxic Mist", "  Ink Storm. Ink Storm", "Dualie", "Dark Tetra Dualies", "  Autobomb. Autobomb", "  Splashdown. Splashdown", "Dualie", "Dualie Squelchers", "  Point Sensor. Point Sensor", "  Tenta Missiles. Tenta Missiles", "Dualie", "Dynamo Roller", "  Ink Mine. Ink Mine", "  Sting Ray. Sting Ray", "Roller", "E-liter 4K", "  Ink Mine. Ink Mine", "  Ink Storm. Ink Storm", "Charger", "E-liter 4K Scope", "  Ink Mine. Ink Mine", "  Ink Storm. Ink Storm", "Charger", "Enperry Splat Dualies", "  Curling Bomb. Curling Bomb", "  Inkjet. Inkjet", "Dualie", "Firefin Splat Charger", "  Splash Wall. Splash Wall", "  Suction-Bomb Launcher. Suction-Bomb Launcher", "Charger", "Firefin Splatterscope", "  Splash Wall. Splash Wall", "  Suction-Bomb Launcher. Suction-Bomb Launcher", "Charger", "Flingza Roller", "  Splash Wall. Splash Wall", "  Splat-Bomb Launcher. Splat-Bomb Launcher", "Roller", "Foil Flingza Roller", "  Suction Bomb. Suction Bomb", "  Tenta Missiles. Tenta Missiles", "Roller", "Foil Squeezer", "  Splat Bomb. Splat Bomb", "  Bubble Blower. Bubble Blower", "Shooter", "Forge Splattershot Pro", "  Suction Bomb. Suction Bomb", "  Bubble Blower. Bubble Blower", "Shooter", "Glooga Dualies", "  Ink Mine. Ink Mine", "  Inkjet. Inkjet", "Dualie", "Glooga Dualies Deco", "  Splash Wall. Splash Wall", "  Baller. Baller", "Dualie", "Gold Dynamo Roller", "  Splat Bomb. Splat Bomb", "  Ink Armor. Ink Armor", "Roller", "Goo Tuber", "  Suction Bomb. Suction Bomb", "  Splashdown. Splashdown", "Charger", "H-3 Nozzlenose", "  Point Sensor. Point Sensor", "  Tenta Missiles. Tenta Missiles", "Shooter", "H-3 Nozzlenose D", "  Suction Bomb. Suction Bomb", "  Ink Armor. Ink Armor", "Shooter", "Heavy Splatling", "  Sprinkler. Sprinkler", "  Sting Ray. Sting Ray", "Splatling", "Heavy Splatling Deco", "  Splash Wall. Splash Wall", "  Bubble Blower. Bubble Blower", "Splatling", "Hero Blaster Replica", "  Toxic Mist. Toxic Mist", "  Splashdown. Splashdown","Shooter", "Hero Brella Replica", "  Sprinkler. Sprinkler", "  Ink Storm. Ink Storm", "Brella", "Hero Charger Replica", "  Splat Bomb. Splat Bomb", "  Sting Ray. Sting Ray", "Charger", "Hero Dualie Replicas", "  Burst Bomb. Burst Bomb", "  Tenta Missiles. Tenta Missiles", "Dualie", "Hero Roller Replica", "  Curling Bomb. Curling Bomb", "  Splashdown. Splashdown", "Roller", "Hero Shot Replica", "  Burst Bomb. Burst Bomb", "  Splashdown. Splashdown", "Shooter", "Hero Slosher Replica", "  Suction Bomb. Suction Bomb", "  Tenta Missiles. Tenta Missiles", "Slosher", "Hero Splatling Replica", "  Sprinkler. Sprinkler", "  Sting Ray. Sting Ray", "Splatling", "Herobrush Replica", "  Autobomb. Autobomb", "  Inkjet. Inkjet", "Roller", "Hydra Splatling", "  Autobomb. Autobomb", "  Splashdown. Splashdown", "Splatling", "Inkbrush", "  Splat Bomb. Splat Bomb", "  Splashdown. Splashdown", "Roller", "Inkbrush Nouveau", "  Ink Mine. Ink Mine", "  Baller. Baller", "Roller", "Jet Squelcher", "  Toxic Mist. Toxic Mist", "  Tenta Missiles. Tenta Missiles", "Shooter", "Krak-On Splat Roller", "  Squid Beakon. Squid Beakon", "  Baller. Baller", "Roller", "L-3 Nozzlenose", "  Curling Bomb. Curling Bomb", "  Baller. Baller", "Shooter", "L-3 Nozzlenose D", "  Burst Bomb. Burst Bomb", "  Inkjet. Inkjet", "Shooter", "Luna Blaster", "  Splat Bomb. Splat Bomb", "  Baller. Baller", "Shooter", "Luna Blaster Neo", "  Ink Mine. Ink Mine", "  Suction-Bomb Launcher. Suction-Bomb Launcher", "Shooter", "Mini Splatling", "  Burst Bomb. Burst Bomb", "  Tenta Missiles. Tenta Missiles", "Splatling", "N-ZAP '85", "  Suction Bomb. Suction Bomb", "  Ink Armor. Ink Armor", "Shooter", "N-ZAP '89", "  Autobomb. Autobomb", "  Tenta Missiles. Tenta Missiles", "Shooter", "Neo Splash-o-matic", "  Burst Bomb. Burst Bomb", "  Suction-Bomb Launcher. Suction-Bomb Launcher", "Shooter", "Neo Sploosh-o-matic", "  Squid Beakon. Squid Beakon", "  Tenta Missiles. Tenta Missiles", "Shooter", "New Squiffer", "  Autobomb. Autobomb", "  Baller. Baller", "Charger", "Octobrush", "  Autobomb. Autobomb", "  Inkjet. Inkjet", "Roller", "Octobrush Nouveau", "  Squid Beakon. Squid Beakon", "  Tenta Missiles. Tenta Missiles", "Roller", "Range Blaster", "  Suction Bomb. Suction Bomb", "  Ink Storm. Ink Storm", "Shooter", "Rapid Blaster", "  Ink Mine. Ink Mine", "  Splat-Bomb Launcher. Splat-Bomb Launcher", "Shooter", "Rapid Blaster Deco", "  Suction Bomb. Suction Bomb", "  Inkjet. Inkjet", "Shooter", "Rapid Blaster Pro", "  Toxic Mist. Toxic Mist", "  Ink Storm. Ink Storm", "Shooter", "Rapid Blaster Pro Deco", "  Splash Wall. Splash Wall", "  Ink Armor. Ink Armor", "Shooter", "Slosher", "  Suction Bomb. Suction Bomb", "  Tenta Missiles. Tenta Missiles", "Slosher", "Slosher Deco", "  Sprinkler. Sprinkler", "  Baller. Baller", "Slosher", "Sloshing Machine", "  Autobomb. Autobomb", "  Sting Ray. Sting Ray", "Slosher", "Sloshing Machine Neo", "  Point Sensor. Point Sensor", "  Splat-Bomb Launcher. Splat-Bomb Launcher", "Slosher", "Sorella Brella", "  Autobomb. Autobomb", "  Splat-Bomb Launcher. Splat-Bomb Launcher", "Brella", "Splash-o-matic", "  Toxic Mist. Toxic Mist", "  Inkjet. Inkjet", "Shooter", "Splat Brella", "  Sprinkler. Sprinkler", "  Ink Storm. Ink Storm", "Brella", "Splat Charger", "  Splat Bomb. Splat Bomb", "  Sting Ray. Sting Ray", "Charger", "Splat Dualies", "  Burst Bomb. Burst Bomb", "  Tenta Missiles. Tenta Missiles", "Dualie", "Splat Roller", "  Curling Bomb. Curling Bomb", "  Splashdown. Splashdown", "Roller", "Splatterscope", "  Splat Bomb. Splat Bomb", "  Sting Ray. Sting Ray", "Charger", "Splattershot", "  Burst Bomb. Burst Bomb", "  Splashdown. Splashdown", "Shooter", "Splattershot Jr.", "  Splat Bomb. Splat Bomb", "  Ink Armor. Ink Armor", "Shooter", "Splattershot Pro", "  Point Sensor. Point Sensor", "  Ink Storm. Ink Storm", "Shooter", "Sploosh-o-matic", "  Curling Bomb. Curling Bomb", "  Splashdown. Splashdown", "Shooter", "Squeezer", "  Splash Wall. Splash Wall", "  Sting Ray. Sting Ray", "Shooter", "Tenta Brella", "  Squid Beakon. Squid Beakon", "  Bubble Blower. Bubble Blower", "Brella", "Tentatek Splattershot", "  Splat Bomb. Splat Bomb", "  Inkjet. Inkjet", "Shooter", "Tri-Slosher", "  Burst Bomb. Burst Bomb", "  Ink Armor. Ink Armor", "Slosher", "Tri-Slosher Nouveau", "  Splat Bomb. Splat Bomb", "  Ink Storm. Ink Storm", "Slosher", "Undercover Brella", "  Ink Mine. Ink Mine", "  Splashdown. Splashdown", "Brella", "Undercover Sorella Brella", "  Splat Bomb. Splat Bomb", "  Baller. Baller", "Brella", "Zink Mini Splatling", "  Curling Bomb. Curling Bomb", "  Ink Storm. Ink Storm", "Splatling"};


        int qtd = 0;
        int i = 0;
        int j = 0;
        for (String s: vecListaArmas) {

            if (j == 4) {
                j = 0;
                i++;
            }

            matListArmas[i][j] = s;
            qtd++;
            j++;
        }

        for( i = 0; i < matListArmas.length; i++) {
            j = 0;
            Arma arma = new Arma();
            arma.setNome(matListArmas[i][j]);
            arma.setSpecial(matListArmas[i][j++]);
            arma.setSub(matListArmas[i][j++]);
            arma.setClasse(matListArmas[i][j++]);

            armaArrayList.add(arma);
        }

        List<String> armasNomes = new ArrayList<>();
        for (Arma a: armaArrayList){
            String nome = a.getNome();
            armasNomes.add(nome);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Tela2.this,
                android.R.layout.simple_spinner_item,armasNomes);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
                armaSelecionada = (String) parent.getItemAtPosition(position);
                armaSelecPos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


}
