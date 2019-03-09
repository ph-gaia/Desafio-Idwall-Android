package phenrique.idwall.desafioidwall.data.network;

import phenrique.idwall.desafioidwall.data.model.Feed;
import phenrique.idwall.desafioidwall.data.model.Login;
import phenrique.idwall.desafioidwall.data.model.RequestLogin;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("signup")
    @Headers({"Content-Type:application/json"})
    Call<Login> requestLogin(@Body RequestLogin body);

    @GET("feed")
    @Headers("Content-Type:application/json")
    Call<Feed> requestFeed(@Query("category") String breed, @Header("Authorization") String token);
}
