package com.example.hanriverretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.hanriverretrofit.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.hangang.msub.kr")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Apiservice service=retrofit.create(Apiservice.class);

        Call<Apidata> userCall =  service.getTemp();
        userCall.enqueue(new Callback<Apidata>() {
            @Override
            public void onResponse(Call<Apidata> call, Response<Apidata> response) {
                Apidata temp = response.body();
                binding.number.setText(temp.temp+"ºC");
                binding.timeset.setText(temp.time+"에 측정됨");
                int ran = (int) (Math.random() * 29);
                binding.text.setText(R.string.a + ran);

            }

            @Override
            public void onFailure(Call<Apidata> call, Throwable t) {
                t.printStackTrace();
                Log.d("asdf",t+"");
            }
        });

    }
}