package com.lin_sir.beautycar.ui.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lin_sir.beautycar.R;
import com.lin_sir.beautycar.api.Url;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 * date at 24/04/2017.
 * describe:
 */

public class EvaluateActivity extends AppCompatActivity {


    @BindView(R.id.evaluate) EditText evaluate;
    @BindView(R.id.submit) TextView submit;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.evaluate, R.id.submit}) public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.evaluate:

                break;
            case R.id.submit:
                if (evaluate.getText().toString().equals("")) {
                    Toast.makeText(EvaluateActivity.this, "评价不能为空~", Toast.LENGTH_SHORT).show();
                    return;
                }

                SharedPreferences pref = getSharedPreferences("user", MODE_PRIVATE);
                String name = pref.getString("userphone", "1");

                String url = Url.url + "evaluate";
                OkHttpUtils
                        .get()
                        .url(url)
                        .addParams("userName", name)
                        .addParams("evaluate", evaluate.getText().toString())
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Request request, Exception e) {
                                Toast.makeText(EvaluateActivity.this, "反馈失败", Toast.LENGTH_SHORT).show();
                                finish();

                            }

                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(EvaluateActivity.this, "反馈成功", Toast.LENGTH_SHORT).show();
                                finish();

                            }
                        });

                break;
        }
    }
}
