package clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jose on 10/2/16.
 */
public class Pokemon {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("tipo")
    @Expose
    private String tipo;
    @SerializedName("nivel")
    @Expose
    private Integer nivel;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    public Pokemon() {
    }


    public Pokemon(Integer id, String url, String nombre, String tipo, Integer nivel, String descripcion) {
        this.id = id;
        this.url = url;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.descripcion = descripcion;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
