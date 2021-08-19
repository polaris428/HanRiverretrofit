package com.hanriver.hanriverretrofit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.hanriverretrofit.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        int status = NetworkStatus.getConnectivityStatus(getApplicationContext());
        if (status == NetworkStatus.TYPE_MOBILE) {

            move();
        } else if (status == NetworkStatus.TYPE_WIFI) {
            move();

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
            builder.setTitle("인터넷 접속 오류");

            builder.setPositiveButton("YES", (dialog, which) -> {
                //"YES" Button Click
                Toast.makeText(getApplicationContext(), "확인", Toast.LENGTH_LONG).show();
                ActivityCompat.finishAffinity(SplashActivity.this);
                System.exit(0);


            });


            AlertDialog alert = builder.create();
            alert.show();
        }


    }






    public void move() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        Handler mHandler = new Handler();
        mHandler.postDelayed(() -> startActivity(intent), 3000); // 0.5초후

    }



}