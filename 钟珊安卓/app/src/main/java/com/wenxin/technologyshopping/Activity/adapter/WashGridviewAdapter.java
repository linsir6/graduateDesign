package com.wenxin.technologyshopping.Activity.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wenxin.technologyshopping.Activity.model.GoodsModel;
import com.wenxin.technologyshopping.R;

import java.util.List;


public class WashGridviewAdapter extends BaseAdapter {
    private Context context;
    private List<GoodsModel> list;
    private Context mContext;

    public WashGridviewAdapter(Context context, List<GoodsModel> list) {
        mContext = context;
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.fragment_wash_gridview, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.picture);
        TextView type1 = (TextView) view.findViewById(R.id.type1);
        TextView type2 = (TextView) view.findViewById(R.id.type2);
        TextView type3 = (TextView) view.findViewById(R.id.type3);
        TextView price = (TextView) view.findViewById(R.id.money);
        TextView name = (TextView) view.findViewById(R.id.product_name);
        Glide
                .with(mContext)
                .load(list.get(position).getImg())
                .into(imageView);
        type1.setText(list.get(position).getType());
        type2.setText(list.get(position).getType2());
        type3.setText(list.get(position).getType3());
        price.setText("￥ "+list.get(position).getPrice());
        name.setText(list.get(position).getName());


        return view;
    }
}
