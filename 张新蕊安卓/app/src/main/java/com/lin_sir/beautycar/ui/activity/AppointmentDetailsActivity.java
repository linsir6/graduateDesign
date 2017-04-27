package com.lin_sir.beautycar.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.lin_sir.beautycar.R;
import com.lin_sir.beautycar.api.Url;
import com.lin_sir.beautycar.model.CarDetails;
import com.lin_sir.beautycar.ui.adapter.AppointmentDetailsAdapter;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by linSir on 17/3/8.预约的详细界面
 */
public class AppointmentDetailsActivity extends AppCompatActivity {

    @BindView(R.id.ac_appointment_details_rc) RecyclerView rc;

    private AppointmentDetailsAdapter adapter;
    private LinearLayoutManager linearLayoutManager;                //linearLayoutManger

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_details);
        ButterKnife.bind(this);
        adapter = new AppointmentDetailsAdapter();
        String type = getIntent().getExtras().getString("type");
        String url = "";
        if (type.equals("wash")) {
            url = Url.url + "get_all_info_wash";
        } else {
            url = Url.url + "get_all_info_beauty";
        }


        OkHttpUtils
                .get()
                .url(url)
                .addParams("id", "3")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    public void onResponse(String response) {
                        try {
                            JSONObject a = new JSONObject(response);
                            JSONArray b = a.getJSONArray("name");
                            Log.i("lin", "---lin---> 11" + b.getJSONObject(0).getString("phone"));

                            List<CarDetails> list = new ArrayList<CarDetails>();
                            for (int i = 0; i < b.length(); i++) {

                                if (b.getJSONObject(i).getString("situation").equals("0")) {
                                    CarDetails obj = new CarDetails(b.getJSONObject(i).getString("order_date"),
                                            b.getJSONObject(i).getString("type"),
                                            b.getJSONObject(i).getString("carinfo"),
                                            b.getJSONObject(i).getString("phone"),
                                            b.getJSONObject(i).getString("phone"),
                                            "");
                                    list.add(obj);
                                }


                            }
                            adapter.refreshList(list);

                        } catch (Exception e) {
                            Log.i("lin", "---lin---> 22");
                        }
                    }
                });


        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        rc.setLayoutManager(linearLayoutManager);
        rc.setAdapter(adapter);


    }


}
