package conexion;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jose on 10/2/16.
 */
public class Conexion {

    public static final String BASE_URL = "https://ul-pokemon.herokuapp.com/";

    //public static final String BASE_URL = "http://192.168.2.50:3500/";
    public Retrofit getConexion(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit;
    }
}
