package com.example.farmatec.API;



import com.example.farmatec.API.Data.SuplementosApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {
    private static final String REMOTE_API_URL = "https://ygorbrilhante.github.io/pharmacy_API/";

    public static SuplementosApi remoteApi;

    public static SuplementosApi getRemoteApi() {return remoteApi;}

    private Repository () {
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SuplementosApi.class);
    }

    public static Repository getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder{
        private static final Repository INSTANCE = new Repository();
    }
}
