package clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jose on 10/9/16.
 */
public class ResponsePokemones {
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("pokemones")
    @Expose
    private Pokemones pokemones;

    public ResponsePokemones(Status status, Pokemones pokemones) {
        this.status = status;
        this.pokemones = pokemones;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Pokemones getPokemones() {
        return pokemones;
    }

    public void setPokemones(Pokemones pokemones) {
        this.pokemones = pokemones;
    }
}
