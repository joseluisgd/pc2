package com.example.jose.pokemong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText eteUsuario;
    EditText etePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eteUsuario = (EditText) findViewById(R.id.eteUsuario);
        etePassword = (EditText) findViewById(R.id.etePassword);
        Button butLogin = (Button) findViewById(R.id.butLogin);
        Button butRegistro = (Button) findViewById(R.id.butRegistro);
        //Boton Login
        butLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Falta validar Login con el webservice.
                if(eteUsuario.getText().toString().equalsIgnoreCase("") || etePassword.getText().toString().equalsIgnoreCase("")){
                    //Equivocacion Toast.
                    Toast.makeText(MainActivity.this, "Error en las credenciales.", Toast.LENGTH_SHORT).show();




                }else{

                    //Pasa a la pantalla de Dashboard
                    Intent intent= new Intent(MainActivity.this,DashboardActivity.class);
                    startActivity(intent);
                }
            }
        });
        butRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,RegistroActivity.class);
                startActivity(intent);
            }
        });
    }
}
