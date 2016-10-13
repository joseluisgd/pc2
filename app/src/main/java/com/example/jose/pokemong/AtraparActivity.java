package com.example.jose.pokemong;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Handler;

import adapters.RecyclerAdapter;
import clases.ListaPokemones;
import clases.Pokemon;
import conexion.Conexion;
import interfaces.UsuariosService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AtraparActivity extends AppCompatActivity {
    private GridLayoutManager mGridLayoutManager;
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private ArrayList<Pokemon> listaPokemones;
    private String username="";
    /*int idPo=0;
    int j=0;
    ArrayList<Pokemon> pokemones;
    */
    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atrapar);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            username = extras.getString("username");
        }
        //listaPokemones = new ArrayList<>();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        //mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setHasFixedSize(true);

        //mRecyclerView.setLayoutManager(mLayoutManager);
        //LinearLayout layout = new LinearLayout(this);
        if(getResources().getConfiguration().orientation==1){
            mGridLayoutManager = new GridLayoutManager(this, 4);
        }else{
            mGridLayoutManager = new GridLayoutManager(this, 6);
        }
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        Conexion conexion = new Conexion();
        Retrofit retrofit = conexion.getConexion();

        final UsuariosService usuariosService = retrofit.create(UsuariosService.class);
        //final Random randomPoke= new Random();
        //final int numPokes = randomPoke.nextInt(10)+1;
        //Random idRandom = new Random();
        //Log.i("AtraparActivity","randomPoke: " + numPokes);
        //pokemones=new ArrayList<>();

 //       pokemones.add(new Pokemon(138,"","",0,"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/138.png",""));
   //     pokemones.add(new Pokemon(94,"","",0,"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/94.png",""));
     //   pokemones.add(new Pokemon(104,"","",0,"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/104.png",""));
        progress = new ProgressDialog(AtraparActivity.this);
        progress.setTitle("Cargando");
        progress.setMessage("Espere mientras carga...");
        progress.setCancelable(false);
        progress.show();
        usuariosService.getListaPokemones().enqueue(new Callback<ListaPokemones>() {
            @Override
            public void onResponse(Call<ListaPokemones> call, Response<ListaPokemones> response) {
                ListaPokemones listaPokemones = response.body();
                mAdapter = new RecyclerAdapter((ArrayList<Pokemon>)listaPokemones.getPokemones(),AtraparActivity.this,username);
                mRecyclerView.setAdapter(mAdapter);
                progress.dismiss();
            }

            @Override
            public void onFailure(Call<ListaPokemones> call, Throwable t) {
                progress.dismiss();
                Intent intent = new Intent(AtraparActivity.this, DashboardActivity.class);
                startActivity(intent);
                Toast.makeText(AtraparActivity.this, "Error en la conexion", Toast.LENGTH_SHORT).show();
            }
        });
        /*
        for (int i=0;i<numPokes;i++){
            j=i;
            idPo = idRandom.nextInt(150)+1;
            usuariosService.getPokeRadar(idPo).enqueue(new Callback<Pokemon>() {
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    Pokemon pokemon = response.body();
                    int status = response.code();
  //                  Log.i("AtraparActivity",response.toString());

//                    Log.i("AtraparActivity","nombre: " + pokemon.getName() + "url: " + pokemon.getImg());
  //                  Log.i("AtraparActivity","idPo: " + idPo);
    //                Log.i("AtraparActivity","COde: " + status);
                    pokemones.add(new Pokemon(pokemon.getId(),
                            pokemon.getName(),
                            pokemon.getType(),
                            pokemon.getNivel(),
                            pokemon.getImg(),
                            pokemon.getDescription()));

                    if(j==numPokes-1){
                        mAdapter = new RecyclerAdapter(pokemones,AtraparActivity.this,username,progress,numPokes);
                        mRecyclerView.setAdapter(mAdapter);
                    }


                }
                @Override
                public void onFailure(Call<Pokemon> call, Throwable t) {
                    Log.e("AtraparActivity",t.getMessage());
                }
            });

        }
    */



    }


 }







