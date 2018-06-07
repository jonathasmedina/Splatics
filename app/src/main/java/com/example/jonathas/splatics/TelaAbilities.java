package com.example.jonathas.splatics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class TelaAbilities extends AppCompatActivity {

    ImageView imageView, imageView1, imageView2, imageView3, imageView4, imageView5, imageView6,
            imageView7, imageView8 ,imageView9, imageView10, imageView11, imageView12, imageView13,
            imageView14, imageView15, imageView16, imageView17, imageView18, imageView19, imageView20,
            imageView21, imageView22, imageView23, imageView24, imageView25;
    GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_abilities);

        findViewByIds();
        ouvintesImageView();
    }

    private void ouvintesImageView() {
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });
        imageView24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getResources().getResourceEntryName(v.getId());
                preencheSlot(s, v);
            }
        });


    }

    private void findViewByIds() {
        gridLayout = (GridLayout) findViewById(R.id.gridLayout1);
        imageView = findViewById(R.id.question_mark1);
        imageView1 = findViewById(R.id.bomb_defense);
        imageView2 = findViewById(R.id.drop_roller);
        imageView3 = findViewById(R.id.ink_resistence);
        imageView4 = findViewById(R.id.ink_saver_main);
        imageView4 = findViewById(R.id.last_ditch_effort);
        imageView5 = findViewById(R.id.object_shredder);
        imageView6 = findViewById(R.id.opening_gambit);
        imageView7 = findViewById(R.id.quick_respawn);
        imageView8 = findViewById(R.id.respawn_punisher);
        imageView9 = findViewById(R.id.s_ability_ability_doubler);
        imageView10 = findViewById(R.id.s_ability_cold_blooded);
        imageView11 = findViewById(R.id.s_ability_comeback);
        imageView12 = findViewById(R.id.s_ability_ink_recovery_up);
        imageView13 = findViewById(R.id.s_ability_ink_saver_sub);
        imageView14 = findViewById(R.id.s_ability_ninja_squid);
        imageView15 = findViewById(R.id.s_ability_quick_super_jump);
        imageView16 = findViewById(R.id.s_ability_run_speed_up);
        imageView17 = findViewById(R.id.s_ability_special_charge_up);
        imageView18 = findViewById(R.id.s_ability_special_saver);
        imageView19 = findViewById(R.id.s_ability_swim_speed_up);
        imageView20 = findViewById(R.id.s_ability_tenacity);
        imageView21 = findViewById(R.id.special_power_up);
        imageView22 = findViewById(R.id.stealth_jump);
        imageView23 = findViewById(R.id.sub_power_up);
        imageView24 = findViewById(R.id.thermal_ink);
    }

    public void preencheSlot(String s, View v){
        //TODO verificar qual slot
        int id = getResources().getIdentifier("com.example.jonathas.splatics:drawable/" + s, null, null);
        imageView.setImageResource(id);
    }

}
