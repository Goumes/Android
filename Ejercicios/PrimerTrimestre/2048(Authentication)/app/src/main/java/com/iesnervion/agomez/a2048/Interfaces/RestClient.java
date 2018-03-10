package com.iesnervion.agomez.a2048.Interfaces;

        import com.iesnervion.agomez.a2048.Entities.Usuario;

        import java.util.ArrayList;

        import retrofit2.Call;
        import retrofit2.http.Body;
        import retrofit2.http.Field;
        import retrofit2.http.FormUrlEncoded;
        import retrofit2.http.GET;
        import retrofit2.http.Header;
        import retrofit2.http.POST;
        import retrofit2.http.PUT;
        import retrofit2.http.Path;
        import retrofit2.http.Query;

/**
 * Created by aleja on 19/02/2018.
 */

public interface RestClient
{
    @GET("/api/users")
    Call<ArrayList<Usuario>> getData(@Header("Authorization") String myAuthString);

    @GET ("api/users/{id}")
    Call<Usuario> getUsuario(@Path("id") String id, @Header("Authorization") String myAuthString);

    @POST("/api/users")
    Call<Usuario> createUser(@Body Usuario user, @Header("Authorization") String myAuthString);

    @PUT("/api/users/{id}")
    Call<Usuario> putUsuario(@Body Usuario usuario, @Path("id") String id, @Header("Authorization") String myAuthString);
}
