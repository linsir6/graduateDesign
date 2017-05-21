package com.lin_sir.beautycar.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jianyuyouhun.library.AutoBannerView;
import com.lin_sir.beautycar.R;
import com.lin_sir.beautycar.app.BaseApplication;
import com.lin_sir.beautycar.model.BannerInfo;
import com.lin_sir.beautycar.ui.activity.AppointmentActivity;
import com.lin_sir.beautycar.ui.activity.BeautyCarActivity;
import com.lin_sir.beautycar.ui.activity.IntroduceActivity;
import com.lin_sir.beautycar.ui.activity.WashCarAppointmentActivity;
import com.lin_sir.beautycar.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created  on 17/2/27.汽车界面
 */
public class CarFragment extends Fragment {
    private AutoBannerView autoBannerView;
    private MyAutoBannerAdapter autoBannerAdapter;
    private TextView title;
    private List<BannerInfo> list;


    //轮播图的事件
    private AutoBannerView.OnBannerChangeListener onBannerChangeListener = new AutoBannerView.OnBannerChangeListener() {
        @Override
        public void onCurrentItemChanged(int position) {
            title.setText(list.get(position).getName());
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        initData();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void initView(View view) {
        autoBannerView = (AutoBannerView) view.findViewById(R.id.autoBannerView);
        title = (TextView) view.findViewById(R.id.bannerTitle);
        autoBannerView.setDotGravity(AutoBannerView.DotGravity.RIGHT);
        autoBannerView.setWaitMilliSceond(3000);
        autoBannerView.setDotMargin(2);
        autoBannerView.setOnBannerChangeListener(onBannerChangeListener);
    }

    private void initData() {
        autoBannerAdapter = new MyAutoBannerAdapter(BaseApplication.get().getAppContext());
        list = new ArrayList<>();
        test();
        autoBannerAdapter.changeItems(list);
        autoBannerView.setAdapter(autoBannerAdapter);
    }

    public void test() {
        BannerInfo info1 = new BannerInfo();
        info1.setUrl("http://pic39.nipic.com/20140312/8821914_212024048000_2.jpg");
        info1.setName("汽车美容");
        list.add(info1);
        BannerInfo info2 = new BannerInfo();
        info2.setUrl("http://4493bz.1985t.com/uploads/allimg/160712/3-160G2111I3.jpg");
        info2.setName("清洗汽车");
        list.add(info2);

    }

    private class MyAutoBannerAdapter implements AutoBannerView.AutoBannerAdapter {
        List<BannerInfo> urls;
        Context context;

        public MyAutoBannerAdapter(Context context) {
            this.context = context;
            this.urls = new ArrayList<>();
        }

        public void changeItems(@NonNull List<BannerInfo> urls) {
            this.urls.clear();
            this.urls.addAll(urls);
        }

        @Override
        public int getCount() {
            return urls.size();
        }

        @Override
        public View getView(View convertView, int position) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(context);
            } else {
                imageView = (ImageView) convertView;
            }
            ImageUtil.requestImg(BaseApplication.get().getAppContext(), urls.get(position).getUrl(), imageView);
            return imageView;
        }
    }

    @OnClick(R.id.fr_car_appointment_wash_car)
    public void onClickWashCar() {
        Intent intent = new Intent(getActivity(), WashCarAppointmentActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.fr_car_appointment)
    public void appointment() {
        Intent intent = new Intent(getActivity(), AppointmentActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.fr_car_beauty)
    public void beauty() {
        Intent intent = new Intent(getActivity(), BeautyCarActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.fr_car_introduce)
    public void introduce() {
        Intent intent = new Intent(getActivity(), IntroduceActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.fr_car_wait)
    public void _wait() {
        Toast.makeText(getActivity(), "该功能尚未开启,敬请期待", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.fr_car_phone)
    public void phone() {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "123456"));//跳转到拨号界面，同时传递电话号码
        startActivity(dialIntent);
    }

    @OnClick(R.id.iv_location)
    public void onClickLocation() {
        Toast.makeText(getActivity(), "当前只开通了哈尔滨城市，其他城市，敬请期待", Toast.LENGTH_SHORT).show();
    }

}
