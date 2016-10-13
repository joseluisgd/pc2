package clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jose on 10/9/16.
 */
public class Atrapar {
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("pokemones")
    @Expose
    private Pokemon pokemones;

    public Atrapar(String username, Pokemon pokemones) {
        this.username = username;
        this.pokemones = pokemones;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Pokemon getPokemon() {
        return pokemones;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemones = pokemon;
    }
}

