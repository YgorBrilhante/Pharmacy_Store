package com.example.farmatec.API;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {
    private static final String REMOTE_API_URL = "https://ygorbrilhante.github.io/pharmacy_API/"

    private PharmacyApi remoteApi;

    public PharmacyApi getRemoteApi() {return remoteApi;}

    private Repository () {
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PharmacyApi.class);

        public static Repository getInstance() {return LazyHolder.INSTANCE;}

        private static class LazyHolder {
            private static final Repository INSTANCE = new Repository();
        }
    }
}
