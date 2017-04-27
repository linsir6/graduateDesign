package com.wenxin.technologyshopping.Activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wenxin.technologyshopping.Activity.app.MyApplication;
import com.wenxin.technologyshopping.Activity.model.GoodsModel;
import com.wenxin.technologyshopping.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linSir
 * date at 2017/4/16.
 * describe:
 */

public class MeOrderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int FOOTER_TYPE = 0;//最后一个的类型
    public static final int HAS_IMG_TYPE = 1;//有图片的类型

    private List<GoodsModel> dataList;

    private ProgressBar mProgress;
    private TextView mNoMore;
    private Context mContext;

    public MeOrderAdapter(Context context) {
        mContext = context;
        dataList = new ArrayList<>();
    }

    public void addData(List<GoodsModel> list) {
        dataList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new AllAddressAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_me_order, parent, false));

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        bindView((AllAddressAdapterViewHolder) holder, dataList.get(position));
    }


    private void bindView(AllAddressAdapterViewHolder holder, GoodsModel data) {

        Glide
                .with(mContext)
                .load(MyApplication.url + data.getImg())
                .into(holder.img);
        holder.product_name.setText(data.getName());
        holder.product_type.setText(data.getType() + " " + data.getType2() + " " + data.getType3());
        holder.product_price.setText("￥ " + data.getPrice());
        Log.i("lin", "---lin's log--->   data.getPrice()  " + data.getPrice());


    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class AllAddressAdapterViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView product_name;
        private TextView product_type;
        private TextView product_price;

        public AllAddressAdapterViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.item_shooping_car_img);
            product_name = (TextView) itemView.findViewById(R.id.item_shooping_car_title);
            product_type = (TextView) itemView.findViewById(R.id.item_shooping_car_type);
            product_price = (TextView) itemView.findViewById(R.id.item_shooping_car_price);

        }
    }

    /**
     * 刷新列表
     */
    public void refreshList(List<GoodsModel> list) {
        dataList.clear();
        dataList.addAll(list);
        notifyDataSetChanged();
    }

    /**
     * 加载更多
     */
    public void loadMoreList(List<GoodsModel> list) {
        dataList.addAll(list);
        notifyDataSetChanged();
    }


}

