package com.shan.technologyshopping.Activity.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.Request;
import com.shan.technologyshopping.Activity.app.MyApplication;
import com.shan.technologyshopping.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * Created by linSir
 * date at 2017/4/14.
 * describe:
 */

public class FeedBackActivity extends AppCompatActivity {

    private Button submit;
    private EditText input;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        submit = (Button) findViewById(R.id.submit);
        input = (EditText) findViewById(R.id.input);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {

                SharedPreferences pref = getSharedPreferences("user", MODE_PRIVATE);
                String name = pref.getString("name", "1");
                String phone = pref.getString("phone", "1");

                String url = MyApplication.url + "callback";
                OkHttpUtils
                        .get()
                        .url(url)
                        .addParams("user_phone", phone)
                        .addParams("user_name", name)
                        .addParams("text", input.getText().toString())
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Request request, Exception e) {
                                Toast.makeText(FeedBackActivity.this, "反馈失败", Toast.LENGTH_SHORT).show();

                                finish();

                            }

                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(FeedBackActivity.this, "反馈成功", Toast.LENGTH_SHORT).show();

                                finish();
                            }
                        });

                finish();
            }
        });


    }
}
