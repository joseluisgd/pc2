package interfaces;


import java.util.List;

import clases.Pokemon;
import clases.Respuesta;
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
    @POST("/login")
    Call<Respuesta> login(@Body Usuario usuario);


    @POST("/registro")
    Call<Respuesta> registrar(@Body Usuario usuario);


    @GET("/usuarios/{username}/pokemones")
    Call<List<Pokemon>> getPokemones(@Query("username")String username);
}
