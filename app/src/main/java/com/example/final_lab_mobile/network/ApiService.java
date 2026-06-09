package com.example.final_lab_mobile.network;

import com.example.outdoorgear.model.ProductResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("products")
    Call<ProductResponse> getProducts();
}
