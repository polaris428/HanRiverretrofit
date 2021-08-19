package com.hanriver.hanriverretrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Apiservice {
    @GET("/")
    Call<Apidata> getTemp();
}
