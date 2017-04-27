package com.wenxin.technologyshopping.Activity.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.wenxin.technologyshopping.Activity.app.MyApplication;
import com.wenxin.technologyshopping.Activity.model.GoodsModel;
import com.wenxin.technologyshopping.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class LaundryAdapter extends BaseAdapter {
    private Context context;
    private List<GoodsModel> list;
    private View fragment_laundry_item1;
    private ImageView isvisibility;
    private TextView fr_laundry_num;
    private TextView fragment_laundry_feesnum;
    private final int ITEM = 0;
    private final int ITEM1 = 1;
    private final int ITEMSUM = 2;
    private int currentType;
    private Button fragment_laundry_pay;
    private int sum = 1;
    private GoodsModel goodsModel;
    private int SumAmounts;
    private Dialog setUserDetailsDialog;

    public LaundryAdapter(Context context, List<GoodsModel> list, View fragment_laundry_item1, ImageView isvisibility) {
        this.context = context;
        this.list = list;
        this.fragment_laundry_item1 = fragment_laundry_item1;
        this.isvisibility = isvisibility;
    }

    @Override
    public int getCount() {
        if (list.size() == 0) {
            isvisibility.setVisibility(View.VISIBLE);
            return 0;
        } else {
            return list.size() + 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        int conut = list.size();
        if (position < conut) {
            return ITEM;
        } else {
            return ITEM1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return ITEMSUM;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View mCourseView = null;
        currentType = getItemViewType(position);
        if (currentType == ITEM1) {
            convertView = fragment_laundry_item1;
            fragment_laundry_feesnum = (TextView) convertView.findViewById(R.id.fragment_laundry_feesnum);

            int price = 0;
            for (int i = 0; i < MyApplication.washJavas.size(); i++) {
                price += Integer.parseInt(MyApplication.washJavas.get(i).getPrice()) *
                        Integer.parseInt(MyApplication.washJavas.get(i).getCount());
            }
            fragment_laundry_feesnum.setText(price + "");

            fragment_laundry_pay = (Button) convertView.findViewById(R.id.fragment_laundry_pay);
            fragment_laundry_pay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.i("lin", "---lin's log--->   点击了 立即支付");

                    showSetPayPwdDialog(context);

                }
            });
        } else {
            mCourseView = convertView;
            mCourseView = View.inflate(context, R.layout.fragment_laundry_item, null);
            ImageView fr_laundry_clothes = (ImageView) mCourseView.findViewById(R.id.fr_laundry_clothes);
            TextView fr_laundry_font = (TextView) mCourseView.findViewById(R.id.fr_laundry_font);
            fr_laundry_num = (TextView) mCourseView.findViewById(R.id.fr_laundry_num);
            TextView fr_laundry_amounts = (TextView) mCourseView.findViewById(R.id.fr_laundry_amounts);
            ImageView fr_laundry_remove = (ImageView) mCourseView.findViewById(R.id.fr_laundry_remove);
            ImageView fr_laundry_cuts = (ImageView) mCourseView.findViewById(R.id.fr_laundry_cuts);
            ImageView fr_laundry_plus = (ImageView) mCourseView.findViewById(R.id.fr_laundry_plus);
            goodsModel = list.get(position);
            fr_laundry_cuts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int text = Integer.parseInt(MyApplication.washJavas.get(position).getCount());
                    if (text > 1) {
                        list.get(position).setCount((text - 1) + "");
                        MyApplication.washJavas.get(position).setCount((text - 1) + "");
                        LaundryAdapter.this.notifyDataSetChanged();
                    }

                    LaundryAdapter.this.notifyDataSetChanged();
                }
            });
            fr_laundry_plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int text = Integer.parseInt(MyApplication.washJavas.get(position).getCount());
                    list.get(position).setCount((text + 1) + "");
                    MyApplication.washJavas.get(position).setCount((text + 1) + "");
                    LaundryAdapter.this.notifyDataSetChanged();
                }
            });
            fr_laundry_remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    LaundryAdapter.this.notifyDataSetChanged();
                }
            });

            Glide
                    .with(context)
                    .load(list.get(position).getImg())
                    .into(fr_laundry_clothes);

            fr_laundry_font.setText(goodsModel.getName());
            if (goodsModel.getCount() == null) {
                fr_laundry_num.setText("1");
            } else {
                fr_laundry_num.setText(goodsModel.getCount());
            }

            fr_laundry_amounts.setText(goodsModel.getPrice());
            convertView = mCourseView;
        }
        return convertView;
    }


    private void showSetPayPwdDialog(Context mContext) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        View mView = LayoutInflater.from(mContext).inflate(R.layout.dialog_input_user, null);
        builder.setView(mView);
        builder.setCancelable(true);
        setUserDetailsDialog = builder.create();
        setUserDetailsDialog.show();

        final EditText e1 = (EditText) mView.findViewById(R.id.e1);//手机号
        final EditText e2 = (EditText) mView.findViewById(R.id.e2);//地址
        TextView b1 = (TextView) mView.findViewById(R.id.b1);//弹出对话框上面的按钮，取消按钮
        TextView b2 = (TextView) mView.findViewById(R.id.b2);//确认按钮

        b2.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                setUserDetailsDialog.dismiss();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {

            @Override public void onClick(View view) {
                SharedPreferences pref = context.getSharedPreferences("user", MODE_PRIVATE);
                String user_id = pref.getString("phone", "null");
                String user_name = pref.getString("name", "null");

                JSONArray jsonArray = new JSONArray();
                for (int i = 0; i < MyApplication.washJavas.size(); i++) {
                    JSONObject object = new JSONObject();
                    try {
                        object.put("user_id", user_id);
                        object.put("user_name", user_name);
                        object.put("user_phone", e1.getText().toString());
                        object.put("user_address", e2.getText().toString());

                        object.put("product_id", MyApplication.washJavas.get(i).getId());
                        object.put("product_name", MyApplication.washJavas.get(i).getName());
                        object.put("product_price", MyApplication.washJavas.get(i).getPrice());
                        object.put("product_count", MyApplication.washJavas.get(i).getCount());
                        object.put("product_img", MyApplication.washJavas.get(i).getImg());
                        object.put("product_type", MyApplication.washJavas.get(i).getType() + " " +
                                MyApplication.washJavas.get(i).getType2() + " " +
                                MyApplication.washJavas.get(i).getType3());
                        Log.i("lin", "---lin's log--->   type    " + MyApplication.washJavas.get(i).getType() + " " +
                                MyApplication.washJavas.get(i).getType2() + " " +
                                MyApplication.washJavas.get(i).getType3());

                    } catch (JSONException e) {
                        Log.i("lin", "---lin's log--->   进入 catch");
                        e.printStackTrace();
                    }
                    jsonArray.put(object);
                }

                Log.i("lin", "---lin's log--->   点击了 立即支付2");

                OkHttpUtils
                        .postString()
                        .url(MyApplication.url + "add_order_list")
                        .content(jsonArray.toString())
                        .mediaType(MediaType.parse("application/json; charset=utf-8"))
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Request request, Exception e) {
                                Log.i("lin", "---lin's log--->   error" + e.toString());

                            }

                            @Override
                            public void onResponse(String response) {
                                setUserDetailsDialog.dismiss();
                                MyApplication.washJavas = new ArrayList<GoodsModel>();
                                list.clear();
                                LaundryAdapter.this.notifyDataSetChanged();

                            }
                        });


            }
        });
    }

}
