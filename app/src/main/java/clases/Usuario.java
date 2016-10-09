package clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jose on 10/2/16.
 */
public class Usuario {
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("pokemones")
    @Expose
    private List<Object> pokemones;



    public Usuario() {
    }


    public Usuario(String user, String password, List<Object> pokemones) {
        this.username = user;
        this.password = password;
        this.pokemones= pokemones;
    }

    public List<Object> getPokemones() {
        return pokemones;
    }

    public void setPokemones(List<Object> pokemones) {
        this.pokemones = pokemones;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = user;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }



}
