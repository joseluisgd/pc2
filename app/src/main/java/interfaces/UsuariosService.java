package interfaces;


import java.util.ArrayList;
import java.util.List;

import clases.Atrapar;
import clases.Pokemon;
import clases.ResponsePokemones;
import clases.Respuesta;
import clases.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jose on 10/2/16.
 */
public interface UsuariosService {
    @POST("/login")
    Call<Respuesta> login(@Body Usuario usuario);


    @POST("/registro")
    Call<Respuesta> registrar(@Body Usuario usuario);


    @GET("/usuario/{username}/pokemones")
    Call<ResponsePokemones> getPokemones(@Path("username") String username);

    @GET("/pokedata/{id}")
    Call<Pokemon> getPokeRadar(@Path("id")int id);

    @POST("/addpoke")
    Call<Respuesta> registrarPokemon(@Body Atrapar atrapar);

}
