package com.example.rbula.newproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String baseUrl = "https://api.ethermine.org/miner/";

    @GET("38de0a18fb8d6aa66ad3eee5f49b72abfcf947fe/workers")
    Call<WorkerObject> getWorks();

}
