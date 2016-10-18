package com.sviluppo.pierangelo.fragmentretrofitgson.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sviluppo.pierangelo.fragmentretrofitgson.Fragment_uno;
import com.sviluppo.pierangelo.fragmentretrofitgson.Model.Cluniacensi;

import java.util.List;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by pierangelo on 17/10/16.
 */


public class CluniacensiService extends Fragment_uno {

    public interface CluniacensiApi extends Call<List<Cluniacensi>> {
        @GET("/api/cluniacensi")
        Call<List<Cluniacensi>> getCluniacensiList();
    }


    public static Retrofit goRetrofit()
    {
        Gson gson = new GsonBuilder().registerTypeAdapter(Cluniacensi.class, new CluniacensiDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://sanpietroinlamosa.it")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }

}
