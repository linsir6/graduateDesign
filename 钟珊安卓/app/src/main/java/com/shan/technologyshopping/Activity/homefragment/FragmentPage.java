package com.shan.technologyshopping.Activity.homefragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shan.technologyshopping.Activity.activity.AllShoppingActivity;
import com.shan.technologyshopping.Activity.activity.SearchActivity;
import com.shan.technologyshopping.Activity.model.GoodsModel;
import com.shan.technologyshopping.R;


/**
 * Created by Clive on 2015/7/28.test
 */
public class FragmentPage extends android.support.v4.app.Fragment implements View.OnClickListener {
    private ImageView fr_morethan_page;
    private ImageView fr_per_page;
    private ViewPager fr_viewpager;
    private ImageView fr_service_page;
    private PopupWindow window;
    private ImageView fr_page_cuts;
    private TextView fr_page_num;
    private TextView fr_page_bag;
    private TextView fr_page_amounts;
    private ImageView fr_page_plus;
    private Button fr_page_sure;
    private RelativeLayout page_main;
    private LayoutInflater inflate;
    private String jian;
    private GoodsModel goodsModel;
    private int sum = 1;
    private int i = 1;
    private View view;
    private static final String TAG = "HomeAutoPlayAdvActivity";
    private int[] images = {R.mipmap.advertisement1, R.mipmap.advertisement2,R.mipmap.advertisement3};
    private PowerManager pm;
    private PowerManager.WakeLock mWakeLock;
    private LinearLayout group;
    private int selectedItem = 0;
    private boolean isScrolling = false;
    private ImageView[] imageDot;
    private ImageView[] mImageViews;
    private ImageView imageView;
    private Thread mThread;
    private RelativeLayout cloth, trouser, shose;
    private ImageView img, img2, img3, img4;

    @Nullable
    @Override

    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, null);
        this.inflate = inflater;
        cloth = (RelativeLayout) view.findViewById(R.id.fr_page_lin_cloth);
        trouser = (RelativeLayout) view.findViewById(R.id.fr_page_lin_trousers);
        shose = (RelativeLayout) view.findViewById(R.id.fr_page_lin_shose);

        fr_morethan_page = (ImageView) view.findViewById(R.id.fr_morethan_page);
        page_main = (RelativeLayout) view.findViewById(R.id.page_main);
        fr_viewpager = (ViewPager) view.findViewById(R.id.fr_viewpager);
        fr_per_page = (ImageView) view.findViewById(R.id.fr_per_page);
        fr_service_page = (ImageView) view.findViewById(R.id.fr_service_page);
        // 设置屏幕长亮
        pm = (PowerManager) getActivity().getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, TAG);
        group = (LinearLayout) view.findViewById(R.id.viewGroup);
        img = (ImageView) view.findViewById(R.id.fr_page_img1);
        img2 = (ImageView) view.findViewById(R.id.fr_page_img2);
        img3 = (ImageView) view.findViewById(R.id.fr_page_img3);
        img4 = (ImageView) view.findViewById(R.id.fr_page_img4);


        initView();
        mThread = new Thread(new MyThread());
        mHandler.sendEmptyMessageDelayed(1, 1000);

        img.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                intent.putExtra("type2", "打底衫");
                startActivity(intent);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                intent.putExtra("type2", "时尚套装");
                startActivity(intent);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                intent.putExtra("type2", "人气潮鞋");
                startActivity(intent);
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                intent.putExtra("type2", "小白鞋");
                startActivity(intent);
            }
        });

        cloth.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AllShoppingActivity.class);
                intent.putExtra("type", "1");
                startActivity(intent);
            }
        });

        trouser.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AllShoppingActivity.class);
                intent.putExtra("type", "2");
                startActivity(intent);
            }
        });

        shose.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AllShoppingActivity.class);
                intent.putExtra("type", "3");
                startActivity(intent);
            }
        });


        /**
         *初始化popouwindow
         */
        initPopouWindow();
        /**
         *打开件洗界面
         */
        fr_per_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(getActivity(), WashActivity.class);
//                startActivity(intent);
            }
        });
        /**
         *打服务说明界面
         * @param
         *
         */
        fr_service_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), MeansActivity.class);
//                startActivity(intent);
            }
        });
        /**
         *popouwindow打开和关闭的判断方式
         * @param
         *
         */
        fr_morethan_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != window && window.isShowing()) {
                    window.dismiss();

                } else {
                    window.showAtLocation(fr_morethan_page, Gravity.BOTTOM, 10, 10);// 显示
                }
            }
        });
        return view;
    }

    /**
     * 主界面的popouwindow初始化
     *
     * @param
     */
    private void initPopouWindow() {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_page_popouwindow, null);
        window = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        window.setFocusable(true);// 加上这个popupwindow中的ListView才可以接收点击事件
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        window.setBackgroundDrawable(dw);
        window.setOutsideTouchable(true);// 触摸popup
        fr_page_bag = (TextView) view.findViewById(R.id.fr_page_bag);
        fr_page_cuts = (ImageView) view.findViewById(R.id.fr_page_cuts);
        fr_page_num = (TextView) view.findViewById(R.id.fr_page_num);
        fr_page_plus = (ImageView) view.findViewById(R.id.fr_page_plus);
        fr_page_sure = (Button) view.findViewById(R.id.fr_page_sure);
        fr_page_amounts = (TextView) view.findViewById(R.id.fr_page_amounts);
        fr_page_cuts.setOnClickListener(FragmentPage.this);
        fr_page_num.setOnClickListener(FragmentPage.this);
        fr_page_plus.setOnClickListener(FragmentPage.this);
        fr_page_sure.setOnClickListener(FragmentPage.this);
    }

    /**
     * popouwindow的点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fr_page_cuts:
                jian = (String) fr_page_num.getText();
                sum = Integer.parseInt(jian);
                if (sum > i) {
                    fr_page_num.setText(sum - 1 + "");
                }
                break;
            case R.id.fr_page_num:
                break;
            case R.id.fr_page_plus:
                String jia = (String) fr_page_num.getText();
                sum = Integer.parseInt(jia);
                if (sum >= i) {
                    fr_page_num.setText(sum + 1 + "");
                }
                break;
            case R.id.fr_page_sure:
                if (null != window && window.isShowing()) {
//                    Boolean isRepeat = isRepeatData();
//                    String name = (String) fr_page_bag.getText();
//                    Log.d("main", "袋洗" + isRepeat);
//                    if (isRepeat) {
//                        for (int i = 0; i < MyApplication.washJavas.size(); i++) {
//                            utils = MyApplication.washJavas.get(i);
//                            if (name.equals(utils.getPictureName())) {
//                                String str1 = utils.getCount();
//                                int a1 = Integer.parseInt(str1);
//                                String str2 = (String) fr_page_num.getText();
//                                int a2 = Integer.parseInt(str2);
//                                utils.setCount(a1 + a2 + "");
//                            }
//                        }
//                    } else {
//                        LaundryUtils utils = new LaundryUtils();
//                        utils.setCount((String) fr_page_num.getText());
//                        utils.setPictureName((String) fr_page_bag.getText());
//                        utils.setAmounts((String) fr_page_amounts.getText());
//                        utils.setPicture(R.mipmap.fragment_page_bagpicture);
//                        MyApplication.washJavas.add(utils);
//                    }
//                    window.dismiss();
//                    fr_page_num.setText("1");
                }
                break;
        }
    }

    private Boolean isRepeatData() {
        String name = (String) fr_page_bag.getText();
//        for (int i = 0; i < MyApplication.washJavas.size(); i++) {
//            utils = MyApplication.washJavas.get(i);
//            if (name.equals(utils.getPictureName())) {
//                return true;
//            }
//        }
        return false;
    }

    Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1:
                    if (mThread != null) {
                        mThread.start();
                    }
                    break;
                case 2:
                    int position = selectedItem;
                    // 设置当前页 + 1的个item被选中。
                    fr_viewpager.setCurrentItem(position + 1);
                    break;
                default:
                    break;
            }
        }

        ;
    };

    /**
     * 通过此线程来实现viewPager轮播的效果
     */
    private void initView() {
        imageDot = new ImageView[images.length];
        for (int i = 0; i < imageDot.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(15, 15);
            params.setMargins(0, 0, 10, 10);
            imageView.setLayoutParams(params);
            imageDot[i] = imageView;
            if (i == 0) {
                imageDot[i].setBackgroundResource(R.drawable.page_indicator_focused);
            } else {
                imageDot[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
            }
            group.addView(imageView);
        }
        // 将图片装载到数组中
        mImageViews = new ImageView[imageDot.length];
        for (int i = 0; i < mImageViews.length; i++) {
            imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageDrawable(getResources().getDrawable(images[i]));
            mImageViews[i] = imageView;
        }
        fr_viewpager.setAdapter(new MyAdapter());
        // 设置监听，主要是设置点点的背景
        fr_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                selectedItem = position;
                setImageBackground(position % mImageViews.length);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        // 设置ViewPager的默认项, 设置为长度的1000倍，这样子开始就能往左滑动
        fr_viewpager.setCurrentItem((mImageViews.length) * 1000);
    }

    /**
     * 设置选中的imageDot的背景
     *
     * @param selectItems
     */
    private void setImageBackground(int selectItems) {
        for (int i = 0; i < imageDot.length; i++) {
            if (i == selectItems) {
                imageDot[i].setBackgroundResource(R.drawable.page_indicator_focused);
            } else {
                imageDot[i].setBackgroundResource(R.drawable.page_indicator_unfocused);
            }
        }
    }

    class MyAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewGroup) container).removeView(mImageViews[position
                    % mImageViews.length]);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int currentItem = position % mImageViews.length;
            ImageView iv = mImageViews[currentItem];
            try {
                // 这里判断是否有parent()是为了避免IllegalStateException异常。
                // 因为在setCurrentItem的时候已经给当前item设置了parent,如果再次设置一个parent。那么就会报IllegalStateException
                // 另外一种处理方式：或者先把之前的parent给remove掉.
                if (iv.getParent() == null) {
                    ((ViewGroup) container).addView(iv);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return iv;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        isScrolling = true;
//        mWakeLock.setReferenceCounted(false);
//        mWakeLock.acquire();
    }

    @Override
    public void onPause() {
        super.onPause();
        // 如果onPause掉。那么轮播就不能执行
        isScrolling = false;
        // 释放屏幕长亮对象
//        mWakeLock.release();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // 中断线程
        mThread.interrupt();
        mThread = null;
    }

    private class MyThread implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    // 4秒播一次
                    Thread.sleep(3000);
                    if (isScrolling) {
                        mHandler.sendEmptyMessage(2);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ;
    }
}
