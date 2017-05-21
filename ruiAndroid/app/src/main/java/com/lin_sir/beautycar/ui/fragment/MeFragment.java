package com.lin_sir.beautycar.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lin_sir.beautycar.R;
import com.lin_sir.beautycar.api.Url;
import com.lin_sir.beautycar.ui.activity.IntroduceActivity;
import com.lin_sir.beautycar.ui.activity.LoginActivity;
import com.lin_sir.beautycar.ui.activity.OrderActivity;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created  on 17/2/27.个人信息界面
 */
public class MeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.fr_me_customer_service)
    public void customer_service() {
        Intent intent = new Intent(getActivity(), IntroduceActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.fr_me_order)
    public void me_order() {
        Intent intent = new Intent(getActivity(), OrderActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.fr_me_setting)
    public void me_setting() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user",
                Activity.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userphone", "1");
        editor.putString("pwd", "1");
        //提交当前数据
        editor.apply();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @OnClick(R.id.fr_me_update)
    public void update() {
        String url = Url.url + "check_version";
        OkHttpUtils
                .get()
                .url(url)
                .addParams("a", "")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        if (response.equals("{\"name\":[{\"content\":\"1.0.0\"}]}")) {
                            Toast.makeText(getActivity(), "当前是最新版本", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "请前往应用商店下载最新版本", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }


}
