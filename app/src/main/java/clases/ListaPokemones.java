package clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Armando on 13/10/2016.
 */
public class ListaPokemones {
    @SerializedName("pokemones")
    @Expose
    private List<Pokemon> pokemones = new ArrayList<Pokemon>();

    /**
     *
     * @return
     * The pokemones
     */
    public List<Pokemon> getPokemones() {
        return pokemones;
    }
    /**
     *
     * @param pokemones
     * The pokemones
     */
    public void setPokemones(List<Pokemon> pokemones) {
        this.pokemones = pokemones;
    }
}
