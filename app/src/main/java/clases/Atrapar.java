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
    @SerializedName("id")
    @Expose
    private int id;

    public Atrapar(String username, int id) {
        this.username = username;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
