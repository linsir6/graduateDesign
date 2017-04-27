package com.lin_sir.beautycar.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lin_sir.beautycar.R;

import butterknife.ButterKnife;

/**
 * Created by linSir on 17/3/8.引导界面
 */
public class StartActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                SharedPreferences pref = getSharedPreferences("user", MODE_PRIVATE);
                String name = pref.getString("userphone", "1");
                String pwd = pref.getString("userphone", "1");

                if (name.equals("1")) {
                    Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 1000);


    }
}
