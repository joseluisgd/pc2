package clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jose on 10/2/16.
 */
public class Usuarios {
    @SerializedName("usuario")
    @Expose
    private Usuario usuario;

    /**
     * No args constructor for use in serialization
     *
     */
    public Usuarios() {
    }

    /**
     *
     * @param usuario
     */
    public Usuarios(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @return
     * The usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario
     * The usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
