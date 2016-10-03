package clases;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jose on 10/2/16.
 */
public class Usuario {
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("password")
    @Expose
    private String password;


    public Usuario() {
    }


    public Usuario(String user, String password) {
        this.user = user;
        this.password = password;
    }


    public String getUsername() {
        return user;
    }

    public void setUsername(String user) {
        this.user = user;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

}
