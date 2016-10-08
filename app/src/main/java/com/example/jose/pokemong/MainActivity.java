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
import clases.Usuario;
import conexion.Conexion;
import interfaces.UsuariosService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    EditText eteUsuario;
    EditText etePassword;
    String username="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(savedInstanceState!=null){
            username=savedInstanceState.getString("id");
        }

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
                if(eteUsuario.getText().toString().equalsIgnoreCase("") ||
                        etePassword.getText().toString().equalsIgnoreCase("")){
                    //Equivocacion Toast.
                    Toast.makeText(MainActivity.this, "Error en las credenciales.", Toast.LENGTH_SHORT).show();
                }else{
                    //Conexion Retrofit.
                    Conexion conexion=new Conexion();
                    Retrofit retrofit = conexion.getConexion();
                    UsuariosService usuariosService = retrofit.create(UsuariosService.class);
                    //Enviar datos al WS
                    Usuario usuario = new Usuario();
                    usuario.setUsername(eteUsuario.getText().toString());
                    usuario.setPassword(etePassword.getText().toString());

                    Call<Respuesta> usuarioCall = usuariosService.login(usuario);
                    //Respuesta del WS
                    usuarioCall.enqueue(new Callback<Respuesta>() {
                        @Override
                        public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                            Respuesta r=response.body();
                            int status = response.code();

                            if(r.getStatus().getCod()==1){
                                username = r.getUser().getUsername();
                                Intent intent= new Intent(MainActivity.this,DashboardActivity.class);
                                intent.putExtra("username",username);
                                Log.i("MainActivity","id"+username);
                                startActivity(intent);

                            }else{
                                Toast.makeText(MainActivity.this, r.getStatus().getMsg(), Toast.LENGTH_SHORT).show();

                            }
                            Log.d("MainActivity","STATUS: " + status);






                            //Log.i("MainActivity",String.valueOf(r.getMsg()));
                        }

                        @Override
                        public void onFailure(Call<Respuesta> call, Throwable t) {
                            Log.e("MainActivity", t.getMessage());
                        }
                    });
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
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putString("username",username );
        super.onSaveInstanceState(savedInstanceState);
    }

}
