package com.example.hanriverretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.hangang.msub.kr")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Apiservice service=retrofit.create(Apiservice.class);

        Call<Apidata> userCall =  service.getTemp();
        userCall.enqueue(new Callback<Apidata>() {
            @Override
            public void onResponse(Call<Apidata> call, Response<Apidata> response) {
                Apidata user = response.body();
                Log.d("asdf",user.temp+"");



            }

            @Override
            public void onFailure(Call<Apidata> call, Throwable t) {
                t.printStackTrace();
                Log.d("asdf",t+"");
            }
        });

    }
}