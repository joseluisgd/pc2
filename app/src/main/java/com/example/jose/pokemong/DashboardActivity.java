package com.example.jose.pokemong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Button butMisPokemones= (Button) findViewById(R.id.butMisPokemones);
        Button butPokemonesDisponibles = (Button) findViewById(R.id.butPokemonesDisponibles);

        butMisPokemones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,MisPokemonesActivity.class);
                startActivity(intent);
            }
        });
        butPokemonesDisponibles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DashboardActivity.this, "La funcion aun no se encuentra disponible", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
