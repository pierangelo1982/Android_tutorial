package com.sviluppo.pierangelo.fragmentretrofitgson;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sviluppo.pierangelo.fragmentretrofitgson.Model.Cluniacensi;
import com.sviluppo.pierangelo.fragmentretrofitgson.Service.CluniacensiDeserializer;
import com.sviluppo.pierangelo.fragmentretrofitgson.Service.CluniacensiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;


public class Fragment_uno extends Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_uno, container, false);

        Call<List<Cluniacensi>> call = new CluniacensiService().getRetrofit().create(CluniacensiService.CluniacensiApi.class).getCluniacensiList();
        call.enqueue(new Callback<List<Cluniacensi>>() {
            @Override
            public void onResponse(Call<List<Cluniacensi>> call, Response<List<Cluniacensi>> response) {

            }

            @Override
            public void onFailure(Call<List<Cluniacensi>> call, Throwable t) {

            }
        });
        return view;
    }

}
