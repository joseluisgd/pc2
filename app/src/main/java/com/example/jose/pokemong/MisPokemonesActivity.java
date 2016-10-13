package com.example.jose.pokemong;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import adapters.RecyclerAdapter;
import clases.ListaPokemones;
import clases.Pokemon;
import clases.ResponsePokemones;
import conexion.Conexion;
import interfaces.UsuariosService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MisPokemonesActivity extends AppCompatActivity {
    TextView tviNivel;
    TextView tviTipo;
    TextView tviDescripcion;
    TextView tviPokemon;
    ImageView img;
    int size;
    int i=0;
    Button butSiguiente;
    Button butAtras;
    String username="";
    List<Pokemon> listaPok;
    ProgressDialog progress;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_pokemones);

        Typeface tf = Typeface.createFromAsset(getAssets(),"font/Pokemon Hollow.ttf");
        TextView tv = (TextView) findViewById(R.id.mispoke);
        TextView tv1 = (TextView) findViewById(R.id.tviPokemon);
        tviPokemon= (TextView) findViewById(R.id.tviPokemon);
        tv.setTypeface(tf);
        tv1.setTypeface(tf);

        tviNivel = (TextView) findViewById(R.id.tviNivel);
        tviTipo = (TextView) findViewById(R.id.tviTipo);
        tviDescripcion = (TextView) findViewById(R.id.tviDescripcion);
        img = (ImageView) findViewById(R.id.img);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            username = extras.getString("username");
        }


        butSiguiente= (Button) findViewById(R.id.butSiguiente);
        butAtras = (Button) findViewById(R.id.butAtras);


        Conexion conexion = new Conexion();
        Retrofit retrofit = conexion.getConexion();

        final UsuariosService usuariosService = retrofit.create(UsuariosService.class);

        progress = new ProgressDialog(this);
        progress.setTitle("Cargando");
        progress.setMessage("Espere mientras carga...");
        progress.setCancelable(false);
        progress.show();
        usuariosService.getMisPokemones(username).enqueue(new Callback<ListaPokemones>() {
            @Override
            public void onResponse(Call<ListaPokemones> call, Response<ListaPokemones> response) {
                final ListaPokemones listaPokemones = response.body();
                listaPok = listaPokemones.getPokemones();
                if(listaPok.size()==0){
                    progress.dismiss();
                    Intent intent = new Intent(MisPokemonesActivity.this, DashboardActivity.class);
                    startActivity(intent);
                    Toast.makeText(MisPokemonesActivity.this, "No tienes pokemones aun!!!", Toast.LENGTH_SHORT).show();
                }else{
                    cargarInformacion();
                    progress.dismiss();
                }
            }
            @Override
            public void onFailure(Call<ListaPokemones> call, Throwable t) {
                progress.dismiss();
                Intent intent = new Intent(MisPokemonesActivity.this, DashboardActivity.class);
                intent.putExtra("username",username);
                startActivity(intent);
                Toast.makeText(MisPokemonesActivity.this, "Error en la conexion", Toast.LENGTH_SHORT).show();
            }
        });

        butSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==listaPok.size()-1){
                    Toast.makeText(MisPokemonesActivity.this, "No tienes mas pokemones", Toast.LENGTH_SHORT).show();
                }else{
                    i++;
                    cargarInformacion();
                }
            }
        });
        butAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0){
                    Toast.makeText(MisPokemonesActivity.this, "Presiona el boton >>", Toast.LENGTH_SHORT).show();
                }else{
                    i--;
                    cargarInformacion();
                }
            }
        });



    }
    public void Menu(View v){
        Intent intent = new Intent(MisPokemonesActivity.this,DashboardActivity.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }
    public void cargarInformacion(){
        Log.i("MisPokemonesActivity",listaPok.get(i).getImg());
        Picasso.with(this).load(listaPok.get(i).getImg()).into(img);
        tviPokemon.setText(listaPok.get(i).getName().toString());
        tviNivel.setText( listaPok.get(i).getNivel().toString());
        tviTipo.setText(listaPok.get(i).getType());
        tviDescripcion.setText(listaPok.get(i).getDescription());
    }

}
