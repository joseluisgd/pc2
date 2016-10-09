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
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.show();
        usuariosService.getPokemones(username).enqueue(new Callback<ResponsePokemones>() {
            @Override
            public void onResponse(Call<ResponsePokemones> call, Response<ResponsePokemones> response) {
                ResponsePokemones responsePokemones = response.body();
                int code= response.code();
                 size= responsePokemones.getPokemones().getPokemones().size();
                Log.i("MisPokemonesActivity","size: " + size);

                    usuariosService.getPokemones(username).enqueue(new Callback<ResponsePokemones>() {
                        @Override
                        public void onResponse(Call<ResponsePokemones> call, Response<ResponsePokemones> response) {
                            ResponsePokemones responseId = response.body() ;
                            final List<Integer> pokesIds = responseId.getPokemones().getPokemones();
                            listaPok= new ArrayList<Pokemon>();
                            for(Integer id : pokesIds){
                                usuariosService.getPokeRadar(id).enqueue(new Callback<Pokemon>() {
                                    @Override
                                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                                        Pokemon pokemon= response.body();
                                        listaPok.add(pokemon);
                                        if(pokesIds.size() == size){
                                            cargarInformacion(listaPok);
                                            progress.dismiss();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Pokemon> call, Throwable t) {
                                        Log.e("AtraparActivity",t.getMessage());
                                    }
                                });
                            }


                            butSiguiente.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(i==size-1){
                                        Toast.makeText(MisPokemonesActivity.this, "Ya no hay mas pokemones", Toast.LENGTH_SHORT).show();
                                    }else{
                                        //TODO: Pasa al siguiente pokemon que trajo del webservice
                                        i++;
                                        cargarInformacion(listaPok);
                                    }

                                }
                            });
                            butAtras.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(i==0){
                                        Toast.makeText(MisPokemonesActivity.this, "Presionar >>", Toast.LENGTH_SHORT).show();
                                    }else{
                                        //TODO: Retrocede al pokemon previo
                                        i--;
                                        cargarInformacion(listaPok);
                                    }
                                }
                            });

                            Button butMenu = (Button) findViewById(R.id.butMenu);
                            butMenu.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(MisPokemonesActivity.this,DashboardActivity.class);
                                    intent.putExtra("username",username);
                                    startActivity(intent);
                                }

                        });
                        }
                        @Override
                        public void onFailure(Call<ResponsePokemones> call, Throwable t) {
                            Log.e("AtraparActivity",t.getMessage());
                        }

                    });
                }
            @Override
            public void onFailure(Call<ResponsePokemones> call, Throwable t) {
                Log.e("AtraparActivity",t.getMessage());
            }
        });





    }

    public void cargarInformacion(List<Pokemon> listaPok){
        Log.i("MisPokemonesActivity",listaPok.get(i).getImg());
        Picasso.with(this).load(listaPok.get(i).getImg()).into(img);
        tviPokemon.setText(listaPok.get(i).getName().toString());
        tviNivel.setText( listaPok.get(i).getNivel().toString());
        tviTipo.setText(listaPok.get(i).getType());
        tviDescripcion.setText(listaPok.get(i).getDescription());
    }

}
