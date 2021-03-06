package com.lin_sir.beautycar.ui.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.lin_sir.beautycar.R;
import com.lin_sir.beautycar.api.Url;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.feezu.liuli.timeselector.TimeSelector;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by  on 17/3/2.预约洗车界面
 */
public class WashCarAppointmentActivity extends AppCompatActivity {

    @BindView(R.id.ac_washCar_car_details) EditText carDetails;
    @BindView(R.id.ac_washCar_phone) EditText phone;
    @BindView(R.id.ac_washCar_time) TextView _time;
    @BindView(R.id.ac_washCar_go) TextView go;
    @BindView(R.id.ac_washCar_type1) RadioButton type1;
    @BindView(R.id.ac_washCar_type2) RadioButton type2;
    @BindView(R.id.ac_washCar_type3) RadioButton type3;
    String type = "快洗";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wash_car_appointment);
        ButterKnife.bind(this);
    }

    @OnCheckedChanged({R.id.ac_washCar_type1, R.id.ac_washCar_type2, R.id.ac_washCar_type3})
    public void typeWashCar() {
        if (type1.isChecked()) {
            go.setText("立即支付 ￥20");
            type = "快洗";
        } else if (type2.isChecked()) {
            go.setText("立即支付 ￥30");
            type = "标洗";
        } else if (type3.isChecked()) {
            type = "精洗";
            go.setText("立即支付 ￥40");
        }
    }

    @OnClick(R.id.ac_washCar_time)
    public void onClickTime() {
        TimeSelector timeSelector = new TimeSelector(this, new TimeSelector.ResultHandler() {
            @Override
            public void handle(String time) {
                _time.setText(time);
            }
        }, "2017-03-04 00:00", "2017-12-1 00:00");
        timeSelector.show();
    }

    @OnClick(R.id.ac_washCar_go)
    public void onClickGo() {
        if (phone.getText().toString().trim().length() != 11) {
            Toast.makeText(WashCarAppointmentActivity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        if (carDetails.getText().toString().trim().equals("")) {
            Toast.makeText(WashCarAppointmentActivity.this, "请输入正确的车辆信息", Toast.LENGTH_SHORT).show();
            return;
        }

        if (_time.getText().toString().equals("您希望的服务时间")) {
            Toast.makeText(WashCarAppointmentActivity.this, "请选择洗车时间", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences pref = getSharedPreferences("user", MODE_PRIVATE);
        String name = pref.getString("userphone", "1");
        String pwd = pref.getString("pwd", "1");

        String url = Url.url + "washcar";
        OkHttpUtils
                .get()
                .url(url)

                .addParams("userName", name)
                .addParams("pwd", pwd)
                .addParams("contact", phone.getText().toString())
                .addParams("carinfo", carDetails.getText().toString())
                .addParams("date", _time.getText().toString())
                .addParams("type", type)


                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        Toast.makeText(WashCarAppointmentActivity.this, "下单失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response) {
                        Log.i("lin", "---lin--- response" + response);
                        if (response.equals("100")) {
                            Toast.makeText(WashCarAppointmentActivity.this, "下单成功", Toast.LENGTH_SHORT).show();
                            finish();

                        } else if (response.equals("103")) {
                            Toast.makeText(WashCarAppointmentActivity.this, "下单失败", Toast.LENGTH_SHORT).show();
                        }

                    }
                });


    }


}
