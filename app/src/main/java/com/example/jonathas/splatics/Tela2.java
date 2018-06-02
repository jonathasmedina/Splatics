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

public class Tela2 extends AppCompatActivity {

    Button recDadosBt;
    Button salvarCadOutroBt;
    Button salvarProxTelaBt;
    EditText nick;
    String selecionado = "";
    String spinnerVal = "";
    String armaSelec = "";
    int armaSelecPos;

    Spinner spinnerLevel, spinnerArma, spinnerHeadGear, spinnerClothing, spinnerShoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        recDadosBt = findViewById(R.id.button);
        salvarCadOutroBt = findViewById(R.id.button3);
        salvarProxTelaBt = findViewById(R.id.button4);
        nick = findViewById(R.id.editText3);
        spinnerArma = findViewById(R.id.spinner9);
        spinnerHeadGear = findViewById(R.id.spinner10);
        spinnerClothing = findViewById(R.id.spinner11);
        spinnerShoes = findViewById(R.id.spinner7);
        spinnerLevel = findViewById(R.id.spinner8);

        popularSpinners(spinnerArma);
        popularSpinners(dadosLevel, spinnerLevel);

        popularSpinners(dadosHeadGear, spinnerHeadGear);
        popularSpinners(dadosClothing, spinnerClothing);
        popularSpinners(dadosShoes, spinnerShoes);


        Intent intent = getIntent();
        final Partida partida = (Partida) intent.getSerializableExtra("partida");

        ArrayList<Jogador> jogadorArrayList = new ArrayList<>();
        Jogador jogador = new Jogador();
        jogador.setNick(nick.getText().toString());
        spinnerVal = valorSelecionadoSpinner(spinnerLevel);
        jogador.setLevel(spinnerVal);
        spinnerVal = valorSelecionadoSpinner(spinnerArma);
        Arma arma = new Arma();
        arma.setNome(spinnerVal);
        jogador.setArma(arma);
        jogadorArrayList.add(jogador);

        partida.setJogadores(jogadorArrayList);

        salvarCadOutroBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela2.this, Tela2.class);
                startActivity(intent);
            }
        });

        salvarProxTelaBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tela2.this, Tela3.class);
                intent.putExtra("partida", (Serializable) partida);
                startActivity(intent);
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

    public void popularSpinners(Spinner spinner){
        ArrayList<Arma> armaArrayList = new ArrayList<>();
        //coluna 0 = nome da arma; 1 sub; 2 especial; 3 classe
        String[][] matListArmas = new String[110][4];
        String[] vecListaArmas = new String[]{
                ".52 Gal", "S2 Weapon Sub Point Sensor.png Point Sensor", "S2 Weapon Special Baller.png Baller", "Shooter", ".52 Gal Deco", "S2 Weapon Sub Curling Bomb.png Curling Bomb", "S2 Weapon Special Sting Ray.png Sting Ray", "Shooter", ".96 Gal", "S2 Weapon Sub Sprinkler.png Sprinkler", "S2 Weapon Special Ink Armor.png Ink Armor", "Shooter", ".96 Gal Deco", "S2 Weapon Sub Splash Wall.png Splash Wall", "S2 Weapon Special Splashdown.png Splashdown", "Shooter", "Aerospray MG", "S2 Weapon Sub Suction Bomb.png Suction Bomb", "S2 Weapon Special Curling-Bomb Launcher.png Curling-Bomb Launcher", "Shooter", "Aerospray RG", "S2 Weapon Sub Sprinkler.png Sprinkler", "S2 Weapon Special Baller.png Baller", "Shooter", "Bamboozler 14 Mk I", "S2 Weapon Sub Curling Bomb.png Curling Bomb", "S2 Weapon Special Tenta Missiles.png Tenta Missiles", "Charger", "Blaster", "S2 Weapon Sub Toxic Mist.png Toxic Mist", "S2 Weapon Special Splashdown.png Splashdown", "Shooter", "Carbon Roller", "S2 Weapon Sub Autobomb.png Autobomb", "S2 Weapon Special Ink Storm.png Ink Storm", "Roller", "Carbon Roller Deco", "S2 Weapon Sub Burst Bomb.png Burst Bomb", "S2 Weapon Special Autobomb Launcher.png Autobomb Launcher", "Roller", "Clash Blaster", "S2 Weapon Sub Splat Bomb.png Splat Bomb", "S2 Weapon Special Sting Ray.png Sting Ray", "Shooter", "Clash Blaster Neo", "S2 Weapon Sub Curling Bomb.png Curling Bomb", "S2 Weapon Special Tenta Missiles.png Tenta Missiles", "Shooter", "Classic Squiffer", "S2 Weapon Sub Point Sensor.png Point Sensor", "S2 Weapon Special Ink Armor.png Ink Armor", "Charger", "Custom Blaster", "S2 Weapon Sub Autobomb.png Autobomb", "S2 Weapon Special Inkjet.png Inkjet", "Shooter", "Custom Dualie Squelchers", "S2 Weapon Sub Splat Bomb.png Splat Bomb", "S2 Weapon Special Ink Storm.png Ink Storm", "Dualie", "Custom E-liter 4K", "S2 Weapon Sub Squid Beakon.png Squid Beakon", "S2 Weapon Special Bubble Blower.png Bubble Blower", "Charger", "Custom E-liter 4K Scope", "S2 Weapon Sub Squid Beakon.png Squid Beakon", "S2 Weapon Special Bubble Blower.png Bubble Blower", "Charger", "Custom Goo Tuber", "S2 Weapon Sub Curling Bomb.png Curling Bomb", "S2 Weapon Special Inkjet.png Inkjet", "Charger", "Custom Jet Squelcher", "S2 Weapon Sub Burst Bomb.png Burst Bomb", "S2 Weapon Special Sting Ray.png Sting Ray", "Shooter", "Custom Range Blaster", "S2 Weapon Sub Curling Bomb.png Curling Bomb", "S2 Weapon Special Bubble Blower.png Bubble Blower", "Shooter", "Custom Splattershot Jr.", "S2 Weapon Sub Autobomb.png Autobomb", "S2 Weapon Special Ink Storm.png Ink Storm", "Shooter", "Dapple Dualies", "S2 Weapon Sub Squid Beakon.png Squid Beakon", "S2 Weapon Special Suction-Bomb Launcher.png Suction-Bomb Launcher", "Dualie", "Dapple Dualies Nouveau", "S2 Weapon Sub Toxic Mist.png Toxic Mist", "S2 Weapon Special Ink Storm.png Ink Storm", "Dualie", "Dark Tetra Dualies", "S2 Weapon Sub Autobomb.png Autobomb", "S2 Weapon Special Splashdown.png Splashdown", "Dualie", "Dualie Squelchers", "S2 Weapon Sub Point Sensor.png Point Sensor", "S2 Weapon Special Tenta Missiles.png Tenta Missiles", "Dualie", "Dynamo Roller", "S2 Weapon Sub Ink Mine.png Ink Mine", "S2 Weapon Special Sting Ray.png Sting Ray", "Roller", "E-liter 4K", "S2 Weapon Sub Ink Mine.png Ink Mine", "S2 Weapon Special Ink Storm.png Ink Storm", "Charger", "E-liter 4K Scope", "S2 Weapon Sub Ink Mine.png Ink Mine", "S2 Weapon Special Ink Storm.png Ink Storm", "Charger", "Enperry Splat Dualies", "S2 Weapon Sub Curling Bomb.png Curling Bomb", "S2 Weapon Special Inkjet.png Inkjet", "Dualie", "Firefin Splat Charger", "S2 Weapon Sub Splash Wall.png Splash Wall", "S2 Weapon Special Suction-Bomb Launcher.png Suction-Bomb Launcher", "Charger", "Firefin Splatterscope", "S2 Weapon Sub Splash Wall.png Splash Wall", "S2 Weapon Special Suction-Bomb Launcher.png Suction-Bomb Launcher", "Charger", "Flingza Roller", "S2 Weapon Sub Splash Wall.png Splash Wall", "S2 Weapon Special Splat-Bomb Launcher.png Splat-Bomb Launcher", "Roller", "Foil Flingza Roller", "S2 Weapon Sub Suction Bomb.png Suction Bomb", "S2 Weapon Special Tenta Missiles.png Tenta Missiles", "Roller", "Foil Squeezer", "S2 Weapon Sub Splat Bomb.png Splat Bomb", "S2 Weapon Special Bubble Blower.png Bubble Blower", "Shooter", "Forge Splattershot Pro", "S2 Weapon Sub Suction Bomb.png Suction Bomb", "S2 Weapon Special Bubble Blower.png Bubble Blower", "Shooter", "Glooga Dualies", "S2 Weapon Sub Ink Mine.png Ink Mine", "S2 Weapon Special Inkjet.png Inkjet", "Dualie", "Glooga Dualies Deco", "S2 Weapon Sub Splash Wall.png Splash Wall", "S2 Weapon Special Baller.png Baller", "Dualie", "Gold Dynamo Roller", "S2 Weapon Sub Splat Bomb.png Splat Bomb", "S2 Weapon Special Ink Armor.png Ink Armor", "Roller", "Goo Tuber", "S2 Weapon Sub Suction Bomb.png Suction Bomb", "S2 Weapon Special Splashdown.png Splashdown", "Charger", "H-3 Nozzlenose", "S2 Weapon Sub Point Sensor.png Point Sensor", "S2 Weapon Special Tenta Missiles.png Tenta Missiles", "Shooter", "H-3 Nozzlenose D", "S2 Weapon Sub Suction Bomb.png Suction Bomb", "S2 Weapon Special Ink Armor.png Ink Armor", "Shooter", "Heavy Splatling", "S2 Weapon Sub Sprinkler.png Sprinkler", "S2 Weapon Special Sting Ray.png Sting Ray", "Splatling", "Heavy Splatling Deco", "S2 Weapon Sub Splash Wall.png Splash Wall", "S2 Weapon Special Bubble Blower.png Bubble Blower", "Splatling", "Hero Blaster Replica", "S2 Weapon Sub Toxic Mist.png Toxic Mist", "S2 Weapon Special Splashdown.png Splashdown", "5", "Shooter", "Hero Brella Replica", "S2 Weapon Sub Sprinkler.png Sprinkler", "S2 Weapon Special Ink Storm.png Ink Storm", "9", "Brella", "Hero Charger Replica", "S2 Weapon Sub Splat Bomb.png Splat Bomb", "S2 Weapon Special Sting Ray.png Sting Ray", "3", "Charger", "Hero Dualie Replicas", "S2 Weapon Sub Burst Bomb.png Burst Bomb", "S2 Weapon Special Tenta Missiles.png Tenta Missiles", "4", "Dualie", "Hero Roller Replica", "S2 Weapon Sub Curling Bomb.png Curling Bomb", "S2 Weapon Special Splashdown.png Splashdown", "3", "Roller", "Hero Shot Replica", "S2 Weapon Sub Burst Bomb.png Burst Bomb", "S2 Weapon Special Splashdown.png Splashdown", "2", "Shooter", "Hero Slosher Replica", "S2 Weapon Sub Suction Bomb.png Suction Bomb", "S2 Weapon Special Tenta Missiles.png Tenta Missiles", "5", "Slosher", "Hero Splatling Replica", "S2 Weapon Sub Sprinkler.png Sprinkler", "S2 Weapon Special Sting Ray.png Sting Ray", "8", "Splatling", "Herobrush Replica", "S2 Weapon Sub Autobomb.png Autobomb", "S2 Weapon Special Inkjet.png Inkjet", "10", "Roller", "Hydra Splatling", "S2 Weapon Sub Autobomb.png Autobomb", "S2 Weapon Special Splashdown.png Splashdown", "Splatling", "Inkbrush", "S2 Weapon Sub Splat Bomb.png Splat Bomb", "S2 Weapon Special Splashdown.png Splashdown", "Roller", "Inkbrush Nouveau", "S2 Weapon Sub Ink Mine.png Ink Mine", "S2 Weapon Special Baller.png Baller", "Roller", "Jet Squelcher", "S2 Weapon Sub Toxic Mist.png Toxic Mist", "S2 Weapon Special Tenta Missiles.png Tenta Missiles", "Shooter", "Krak-On Splat Roller", "S2 Weapon Sub Squid Beakon.png Squid Beakon", "S2 Weapon Special Baller.png Baller", "Roller", "L-3 Nozzlenose", "S2 Weapon Sub Curling Bomb.png Curling Bomb", "S2 Weapon Special Baller.png Baller", "Shooter", "L-3 Nozzlenose D", "S2 Weapon Sub Burst Bomb.png Burst Bomb", "S2 Weapon Special Inkjet.png Inkjet", "Shooter", "Luna Blaster", "S2 Weapon Sub Splat Bomb.png Splat Bomb", "S2 Weapon Special Baller.png Baller", "Shooter", "Luna Blaster Neo", "S2 Weapon Sub Ink Mine.png Ink Mine", "S2 Weapon Special Suction-Bomb Launcher.png Suction-Bomb Launcher", "Shooter", "Mini Splatling", "S2 Weapon Sub Burst Bomb.png Burst Bomb", "S2 Weapon Special Tenta Missiles.png Tenta Missiles", "Splatling", "N-ZAP '85", "S2 Weapon Sub Suction Bomb.png Suction Bomb", "S2 Weapon Special Ink Armor.png Ink Armor", "Shooter", "N-ZAP '89", "S2 Weapon Sub Autobomb.png Autobomb", "S2 Weapon Special Tenta Missiles.png Tenta Missiles", "Shooter", "Neo Splash-o-matic", "S2 Weapon Sub Burst Bomb.png Burst Bomb", "S2 Weapon Special Suction-Bomb Launcher.png Suction-Bomb Launcher", "Shooter", "Neo Sploosh-o-matic", "S2 Weapon Sub Squid Beakon.png Squid Beakon", "S2 Weapon Special Tenta Missiles.png Tenta Missiles", "Shooter", "New Squiffer", "S2 Weapon Sub Autobomb.png Autobomb", "S2 Weapon Special Baller.png Baller", "Charger", "Octobrush", "S2 Weapon Sub Autobomb.png Autobomb", "S2 Weapon Special Inkjet.png Inkjet", "Roller", "Octobrush Nouveau", "S2 Weapon Sub Squid Beakon.png Squid Beakon", "S2 Weapon Special Tenta Missiles.png Tenta Missiles", "Roller", "Range Blaster", "S2 Weapon Sub Suction Bomb.png Suction Bomb", "S2 Weapon Special Ink Storm.png Ink Storm", "Shooter", "Rapid Blaster", "S2 Weapon Sub Ink Mine.png Ink Mine", "S2 Weapon Special Splat-Bomb Launcher.png Splat-Bomb Launcher", "Shooter", "Rapid Blaster Deco", "S2 Weapon Sub Suction Bomb.png Suction Bomb", "S2 Weapon Special Inkjet.png Inkjet", "Shooter", "Rapid Blaster Pro", "S2 Weapon Sub Toxic Mist.png Toxic Mist", "S2 Weapon Special Ink Storm.png Ink Storm", "Shooter", "Rapid Blaster Pro Deco", "S2 Weapon Sub Splash Wall.png Splash Wall", "S2 Weapon Special Ink Armor.png Ink Armor", "Shooter", "Slosher", "S2 Weapon Sub Suction Bomb.png Suction Bomb", "S2 Weapon Special Tenta Missiles.png Tenta Missiles", "Slosher", "Slosher Deco", "S2 Weapon Sub Sprinkler.png Sprinkler", "S2 Weapon Special Baller.png Baller", "Slosher", "Sloshing Machine", "S2 Weapon Sub Autobomb.png Autobomb", "S2 Weapon Special Sting Ray.png Sting Ray", "Slosher", "Sloshing Machine Neo", "S2 Weapon Sub Point Sensor.png Point Sensor", "S2 Weapon Special Splat-Bomb Launcher.png Splat-Bomb Launcher", "Slosher", "Sorella Brella", "S2 Weapon Sub Autobomb.png Autobomb", "S2 Weapon Special Splat-Bomb Launcher.png Splat-Bomb Launcher", "Brella", "Splash-o-matic", "S2 Weapon Sub Toxic Mist.png Toxic Mist", "S2 Weapon Special Inkjet.png Inkjet", "Shooter", "Splat Brella", "S2 Weapon Sub Sprinkler.png Sprinkler", "S2 Weapon Special Ink Storm.png Ink Storm", "Brella", "Splat Charger", "S2 Weapon Sub Splat Bomb.png Splat Bomb", "S2 Weapon Special Sting Ray.png Sting Ray", "Charger", "Splat Dualies", "S2 Weapon Sub Burst Bomb.png Burst Bomb", "S2 Weapon Special Tenta Missiles.png Tenta Missiles", "Dualie", "Splat Roller", "S2 Weapon Sub Curling Bomb.png Curling Bomb", "S2 Weapon Special Splashdown.png Splashdown", "Roller", "Splatterscope", "S2 Weapon Sub Splat Bomb.png Splat Bomb", "S2 Weapon Special Sting Ray.png Sting Ray", "Charger", "Splattershot", "S2 Weapon Sub Burst Bomb.png Burst Bomb", "S2 Weapon Special Splashdown.png Splashdown", "Shooter", "Splattershot Jr.", "S2 Weapon Sub Splat Bomb.png Splat Bomb", "S2 Weapon Special Ink Armor.png Ink Armor", "Shooter", "Splattershot Pro", "S2 Weapon Sub Point Sensor.png Point Sensor", "S2 Weapon Special Ink Storm.png Ink Storm", "Shooter", "Sploosh-o-matic", "S2 Weapon Sub Curling Bomb.png Curling Bomb", "S2 Weapon Special Splashdown.png Splashdown", "Shooter", "Squeezer", "S2 Weapon Sub Splash Wall.png Splash Wall", "S2 Weapon Special Sting Ray.png Sting Ray", "Shooter", "Tenta Brella", "S2 Weapon Sub Squid Beakon.png Squid Beakon", "S2 Weapon Special Bubble Blower.png Bubble Blower", "Brella", "Tentatek Splattershot", "S2 Weapon Sub Splat Bomb.png Splat Bomb", "S2 Weapon Special Inkjet.png Inkjet", "Shooter", "Tri-Slosher", "S2 Weapon Sub Burst Bomb.png Burst Bomb", "S2 Weapon Special Ink Armor.png Ink Armor", "Slosher", "Tri-Slosher Nouveau", "S2 Weapon Sub Splat Bomb.png Splat Bomb", "S2 Weapon Special Ink Storm.png Ink Storm", "Slosher", "Undercover Brella", "S2 Weapon Sub Ink Mine.png Ink Mine", "S2 Weapon Special Splashdown.png Splashdown", "Brella", "Undercover Sorella Brella", "S2 Weapon Sub Splat Bomb.png Splat Bomb", "S2 Weapon Special Baller.png Baller", "Brella", "Zink Mini Splatling", "S2 Weapon Sub Curling Bomb.png Curling Bomb", "S2 Weapon Special Ink Storm.png Ink Storm", "Splatling"};


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
                arma.setSub(matListArmas[i][j++]);
                arma.setSpecial(matListArmas[i][j++]);
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
                 armaSelec = (String) parent.getItemAtPosition(position);
                 armaSelecPos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }


}
