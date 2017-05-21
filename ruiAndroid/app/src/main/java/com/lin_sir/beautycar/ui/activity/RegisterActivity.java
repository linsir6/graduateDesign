package com.lin_sir.beautycar.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
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
 * Created  on 17/3/3.注册页面
 */
public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.ac_register_username) EditText username;
    @BindView(R.id.ac_register_pwd) EditText pwd;
    @BindView(R.id.ac_register_pwd_second) EditText pwd_second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ac_register_register)
    public void onClickRegister() {
        if (username.getText().toString().length() != 11) {
            Toast.makeText(RegisterActivity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!pwd.getText().toString().equals(pwd_second.getText().toString())) {
            Toast.makeText(RegisterActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
            return;
        }

        String url = Url.url + "register";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("phone", username.getText().toString().trim())
                .addParams("pwd", pwd.getText().toString().trim())
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        Log.i("lin", "---lin's log--->   " + e.toString());
                        Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onResponse(String response) {
                        if (response.equals("100")) {
                            Toast.makeText(RegisterActivity.this, "注册成功,请登录", Toast.LENGTH_SHORT).show();
                            finish();
                        } else if (response.equals("101")) {
                            Toast.makeText(RegisterActivity.this, "注册失败--用户已存在", Toast.LENGTH_SHORT).show();
                        }

                    }
                });


    }
}
