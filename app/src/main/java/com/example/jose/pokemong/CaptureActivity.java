package com.example.jose.pokemong;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import clases.Atrapar;
import clases.Pokemon;
import clases.Respuesta;
import conexion.Conexion;
import interfaces.UsuariosService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CaptureActivity extends AppCompatActivity {
    private ImageView mostrarPoke;
    private String url="";
    private String username="";
    private int idPoke=0;
    private String nombrePoke="";
    private int nivel=0;
    private String tipo="";
    private String descripcion="";
    ProgressDialog progress;
    Pokemon pokemon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            url = extras.getString("url");
            idPoke = extras.getInt("idPoke");
            username = extras.getString("username");
            nombrePoke=extras.getString("nombrepoke");
            tipo=extras.getString("tipo");
            descripcion=extras.getString("descripcion");
            nivel=extras.getInt("nivel");
        }
        pokemon=new Pokemon();
        pokemon.setName(nombrePoke);
        pokemon.setType(tipo);
        pokemon.setDescription(descripcion);
        pokemon.setNivel(nivel);
        pokemon.setId(idPoke);
        pokemon.setImg(url);
        mostrarPoke = (ImageView)findViewById(R.id.mostrarPoke);
        Picasso.with(this).load(url).into(mostrarPoke);

        mostrarPoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conexion conexion = new Conexion();
                Retrofit retrofit = conexion.getConexion();
                final UsuariosService usuariosService = retrofit.create(UsuariosService.class);
                progress = new ProgressDialog(CaptureActivity.this);
                progress.setTitle("Cargando");
                progress.setMessage("Capturando pokemon");
                progress.setCancelable(false);
                progress.show();
                usuariosService.registrarPokemon(new Atrapar(username,pokemon)).enqueue(new Callback<Respuesta>() {
                    @Override
                    public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                        Respuesta respuesta= response.body();
                        Toast.makeText(CaptureActivity.this, respuesta.getStatus().getMsg(), Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(CaptureActivity.this,DashboardActivity.class);
                        intent.putExtra("username",username);
                        progress.dismiss();
                        startActivity(intent);
                    }
                    @Override
                    public void onFailure(Call<Respuesta> call, Throwable t) {
                        Log.e("CaptureActivity",t.getMessage());
                        progress.dismiss();
                        Toast.makeText(CaptureActivity.this, "Error en la conexion", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
