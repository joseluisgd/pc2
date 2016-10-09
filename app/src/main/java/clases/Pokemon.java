package clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jose on 10/2/16.
 */
public class Pokemon {

    //
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("nivel")
    @Expose
    private Integer nivel;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("description")
    @Expose
    private String description;

    public Pokemon() {
    }

    public Pokemon(Integer id, String name, String type, Integer nivel, String img, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.nivel = nivel;
        this.img = img;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}