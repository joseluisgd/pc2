package com.example.jose.pokemong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MisPokemonesActivity extends AppCompatActivity {
    TextView tviNivel;
    TextView tviTipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_pokemones);
        tviNivel = (TextView) findViewById(R.id.tviNivel);
        tviTipo = (TextView) findViewById(R.id.tviTipo);

        Button butSiguiente = (Button) findViewById(R.id.butSiguiente);
        butSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Pasa al siguiente pokemon que trajo del webservice
            }
        });

        Button butAtras = (Button) findViewById(R.id.butAtras);
        butAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Retrocede al pokemon previo
            }
        });

        Button butMenu = (Button) findViewById(R.id.butMenu);
        butMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MisPokemonesActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
