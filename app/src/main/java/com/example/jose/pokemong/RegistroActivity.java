package com.example.jose.pokemong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import clases.Respuesta;
import clases.Usu;
import conexion.Conexion;
import interfaces.UsuariosService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegistroActivity extends AppCompatActivity {
    EditText eteRegUsuario;
    EditText eteRegPassword;
    EditText eteRegPassword2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        eteRegUsuario = (EditText) findViewById(R.id.eteRegUsuario);
        eteRegPassword = (EditText) findViewById(R.id.eteRegPassword);
        eteRegPassword2 = (EditText) findViewById(R.id.eteRegPassword2);

        Button butGuardar = (Button) findViewById(R.id.butGuardar);
        //Boton Registro
        butGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eteRegUsuario.getText().toString().equalsIgnoreCase("") ||
                        eteRegPassword.getText().toString().equalsIgnoreCase("") ||
                        eteRegPassword2.getText().toString().equalsIgnoreCase("")){

                    //Mensaje Toast
                    Toast.makeText(RegistroActivity.this, "Falta llenar datos", Toast.LENGTH_SHORT).show();

                }else{
                    //TODO:Comparar el usuario ingresado con los usuarios registrados en el webservice
                    if(eteRegUsuario.getText().toString().equalsIgnoreCase("")){
                        Toast.makeText(RegistroActivity.this, "Utilizar otro usuario.", Toast.LENGTH_SHORT).show();
                    }else{
                        //TODO:Guardar registros en el webservice.
                        if(eteRegPassword.getText().toString().equalsIgnoreCase(eteRegPassword2.getText().toString())){

                            Conexion conexion = new Conexion();
                            Retrofit retrofit= conexion.getConexion();

                            UsuariosService usuariosService = retrofit.create(UsuariosService.class);

                            Usu usu= new Usu();
                            usu.setUsername(eteRegUsuario.getText().toString());
                            usu.setPassword(eteRegPassword.getText().toString());

                            Call<Respuesta> usuarioCall = usuariosService.registrar(usu);

                            usuarioCall.enqueue(new Callback<Respuesta>() {
                                @Override
                                public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                                    Respuesta respuesta = response.body();
                                    int status = response.code();
                                    Log.d("MainActivity","Status: " + status);

                                    Toast.makeText(RegistroActivity.this, "Datos guardados corrrectamente.", Toast.LENGTH_SHORT).show();
                                    Intent intent= new Intent(RegistroActivity.this,MainActivity.class);
                                    startActivity(intent);
                                }

                                @Override
                                public void onFailure(Call<Respuesta> call, Throwable t) {
                                    Log.e("MainActivity", t.getMessage());
                                }
                            });



                        }else{
                            Toast.makeText(RegistroActivity.this, "Passwords no son iguales", Toast.LENGTH_SHORT).show();
                        }




                        //Toast e Intent

                    }

                }

            }
        });

    }
}
