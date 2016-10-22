package com.sviluppo.pierangelo.fragmentretrofitgson;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sviluppo.pierangelo.fragmentretrofitgson.Model.Cluniacensi;
import com.sviluppo.pierangelo.fragmentretrofitgson.Service.CluniacensiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_uno extends Fragment
{
    TextView textTest;

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

                if (response.isSuccessful()) {
                    List<Cluniacensi> clu = response.body();
                    for (int i = 0; i<clu.size(); i++) {
                        Cluniacensi c = clu.get(i);
                        Log.d("test", c.getTitolo());
                    }

                    textTest = (TextView) getView().findViewById(R.id.textViewTest);
                    textTest.setText(response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<List<Cluniacensi>> call, Throwable t) {

            }
        });
        return view;
    }

}
