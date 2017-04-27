package com.lin_sir.beautycar.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
 * Created by linSir on 17/2/12.登录界面
 */
public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.ac_login_username) EditText userName;
    @BindView(R.id.ac_login_userpwd) EditText userPwd;
    @BindView(R.id.ac_login_login) TextView login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ac_login_login)
    public void onCLickLogin() {
        if (userName.getText().toString().length() != 11) {
            Toast.makeText(LoginActivity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        if (userPwd.getText().toString().trim().equals("")) {
            Toast.makeText(LoginActivity.this, "用户密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String url = Url.url + "login";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("phone", userName.getText().toString().trim())
                .addParams("pwd", userPwd.getText().toString().trim())
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                        Log.i("lin", "----lin's log--->登录失败1" + e.toString());

                    }

                    @Override
                    public void onResponse(String response) {
                        Log.i("lin", "----lin's log--->登录失败2" + response);

                        if (response.equals("100")) {
                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            //缓存
                            SharedPreferences sharedPreferences = getSharedPreferences("user",
                                    Activity.MODE_PRIVATE);
                            //实例化SharedPreferences.Editor对象
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            //用putString的方法保存数据
                            editor.putString("userphone", userName.getText().toString());
                            editor.putString("pwd", userPwd.getText().toString());
                            //提交当前数据
                            editor.apply();

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else if (response.equals("102")) {
                            Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }

    @OnClick(R.id.ac_login_register)
    public void onCLickRegister() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
