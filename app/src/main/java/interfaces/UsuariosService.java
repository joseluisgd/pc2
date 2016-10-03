package interfaces;


import java.util.List;

import clases.Pokemones;
import clases.Respuesta;
import clases.Usu;
import clases.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by jose on 10/2/16.
 */
public interface UsuariosService {
    @POST("/usuarios/login")
    Call<Respuesta> login(@Body Usuario usuario);


    @POST("/usuarios")
    Call<Respuesta> registrar(@Body Usu usuario);


    @GET("/usuarios/{id_usuario}/pokemones")
    Call<List<Pokemones>> getPokemones(@Query("{id_usuario}")int id);
}
