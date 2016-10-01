package com.example.jose.pokemong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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




                        //Toast e Intent
                        Toast.makeText(RegistroActivity.this, "Datos guardados corrrectamente.", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(RegistroActivity.this,MainActivity.class);
                        startActivity(intent);
                    }

                }

            }
        });

    }
}
