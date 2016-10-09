package com.example.jose.pokemong;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DashboardActivity extends AppCompatActivity {
    String username="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Button butMisPokemones= (Button) findViewById(R.id.butMisPokemones);
        Button butPokemonesDisponibles = (Button) findViewById(R.id.butPokemonesDisponibles);
        Typeface tf = Typeface.createFromAsset(getAssets(),"font/Pokemon Solid.ttf");
        butMisPokemones.setTypeface(tf);
        butPokemonesDisponibles.setTypeface(tf);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            username = extras.getString("username");
        }
        butMisPokemones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,MisPokemonesActivity.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });
        butPokemonesDisponibles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,AtraparActivity.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });
    }
}
