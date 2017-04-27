package com.lin_sir.beautycar.ui.adapter;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lin_sir.beautycar.R;
import com.lin_sir.beautycar.ui.fragment.CarFragment;
import com.lin_sir.beautycar.ui.fragment.MeFragment;

/**
 * Created by linSir on 17/2/27.主界面的适配器
 */
public class HomeFragmentAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments = {new CarFragment(), new MeFragment()};
    private int[] imgSelectIds = {R.drawable.select_home, R.drawable.select_people};
    private int[] imgNormalIds = {R.drawable.unselect_home, R.drawable.unselect_people};
    private ImageView iv;
    private View view;
    private Context context;
    private String[] text = {"首页", "我的"};

    public HomeFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    public void setupTabLayout(final TabLayout tabLayout, final ViewPager viewPager) {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tabLayout.getSelectedTabPosition());
                View view = tab.getCustomView();
                ImageView iv = (ImageView) view.findViewById(R.id.iv_item_custom_tab);
                iv.setImageResource(imgSelectIds[tab.getPosition()]);
                TextView tv = (TextView) view.findViewById(R.id.tv_item_custom_tab);
                tv.setTextColor(0xffffc107);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                ImageView iv = (ImageView) view.findViewById(R.id.iv_item_custom_tab);
                iv.setImageResource(imgNormalIds[tab.getPosition()]);
                TextView tv = (TextView) view.findViewById(R.id.tv_item_custom_tab);
                tv.setTextColor(0xffaeaeae);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    public View getTabView(int position, Context context, boolean select) {
        view = LayoutInflater.from(context).inflate(R.layout.custom_tablayout_item, null);
        TextView tv = (TextView) view.findViewById(R.id.tv_item_custom_tab);
        iv = (ImageView) view.findViewById(R.id.iv_item_custom_tab);
        tv.setText(text[position]);
        if (select) {
            iv.setImageResource(imgSelectIds[position]);
            tv.setTextColor(0xffffc107);
        } else {
            iv.setImageResource(imgNormalIds[position]);
            tv.setTextColor(0xffaeaeae);
        }
        return view;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

}
