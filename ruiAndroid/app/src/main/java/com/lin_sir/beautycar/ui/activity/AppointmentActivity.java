package com.lin_sir.beautycar.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lin_sir.beautycar.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created on 17/3/7.预约情况界面
 */
public class AppointmentActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ac_appointment_img1)
    public void onClickImg1() {
        Intent intent = new Intent(AppointmentActivity.this, AppointmentDetailsActivity.class);
        intent.putExtra("type", "beauty");//跳转的时候带一个参数进去
        startActivity(intent);
    }

    @OnClick(R.id.ac_appointment_img2)
    public void onClickImg2() {
        Intent intent = new Intent(AppointmentActivity.this, AppointmentDetailsActivity.class);
        intent.putExtra("type", "wash");
        startActivity(intent);
    }

}
