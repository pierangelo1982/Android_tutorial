package com.sviluppo.pierangelo.fragmentretrofitgson.Service;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by pierangelo on 17/10/16.
 */

public class BaseService {

    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.sanpietroinlamosa.it/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
