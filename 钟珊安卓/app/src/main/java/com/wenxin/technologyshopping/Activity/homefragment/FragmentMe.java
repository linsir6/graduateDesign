package com.wenxin.technologyshopping.Activity.homefragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wenxin.technologyshopping.Activity.activity.FeedBackActivity;
import com.wenxin.technologyshopping.Activity.activity.HomeActivity;
import com.wenxin.technologyshopping.Activity.activity.LawActivity;
import com.wenxin.technologyshopping.Activity.activity.LoginActivity;
import com.wenxin.technologyshopping.Activity.activity.MeOrderActivity;
import com.wenxin.technologyshopping.R;


public class FragmentMe extends android.support.v4.app.Fragment {

    private TextView userName, userPhone;
    private RelativeLayout meOrder, feedBack, law, exit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, null);
        userName = (TextView) view.findViewById(R.id.fr_me_user_name);
        userPhone = (TextView) view.findViewById(R.id.fr_me_user_phone);
        meOrder = (RelativeLayout) view.findViewById(R.id.fr_me_me_order);
        feedBack = (RelativeLayout) view.findViewById(R.id.fr_me_feedback);
        law = (RelativeLayout) view.findViewById(R.id.fragment_me_law);
        exit = (RelativeLayout) view.findViewById(R.id.fr_me_exit);

        meOrder.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                startActivity(new Intent(getActivity(), MeOrderActivity.class));
            }
        });

        feedBack.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                startActivity(new Intent(getActivity(), FeedBackActivity.class));
            }
        });

        law.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                startActivity(new Intent(getActivity(), LawActivity.class));
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user",
                        Activity.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                //用putString的方法保存数据
                editor.putString("phone", "null");
                editor.putString("pwd", "null");
                editor.putString("name", "null");
                //提交当前数据
                editor.apply();
                Toast.makeText(getActivity(), "登陆成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }
}
















