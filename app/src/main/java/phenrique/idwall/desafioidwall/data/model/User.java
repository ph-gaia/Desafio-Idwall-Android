package phenrique.idwall.desafioidwall.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("token")
    @Expose
    private String token;

    public User(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
