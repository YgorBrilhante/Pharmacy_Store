package com.example.farmatec.API.Data;

import com.example.farmatec.ui.main.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SuplementosApi {
        @GET("suplementos.json")
        Call<List<Product>> getSuplementos();
    }

