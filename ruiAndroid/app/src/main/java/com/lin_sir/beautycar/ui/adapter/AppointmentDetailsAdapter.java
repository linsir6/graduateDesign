package com.lin_sir.beautycar.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lin_sir.beautycar.R;
import com.lin_sir.beautycar.model.CarDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  on 17/3/8.汽车界面显示的activity
 */
public class AppointmentDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int FOOTER_TYPE = 0;//最后一个的类型
    public static final int HAS_IMG_TYPE = 1;//有图片的类型

    private List<CarDetails> dataList;

    private TextView mNoMore;

    public AppointmentDetailsAdapter() {
        dataList = new ArrayList<>();
    }

    public void addData(List<CarDetails> list) {
        dataList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == FOOTER_TYPE) {
            return new FooterItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_footer, parent, false));
        } else {
            return new AllAddressAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_appointment, parent, false));
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == FOOTER_TYPE) {
            bindFooterView((FooterItemViewHolder) holder);
        } else {

            if (dataList.get(position) != null) {
                bindView((AllAddressAdapterViewHolder) holder, dataList.get(position));
            }

        }
    }

    @Override
    public int getItemViewType(int position) {//10个预约情况 0-9  1个已加载全部   10+1 =11
        if (position + 1 == getItemCount()) {
            return FOOTER_TYPE;
        } else {
            CarDetails news = dataList.get(position);
            return HAS_IMG_TYPE;
        }
    }

    private void bindView(AllAddressAdapterViewHolder holder, CarDetails data) {

        holder.time.setText(data.getTime());
        holder.type.setText(data.getType());
        holder.context.setText(data.getContext());
        holder.userPhone.setText(data.getUserPhone());
        holder.userName.setText(data.getUserName());
    }


    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size() + 1;
    }

    public static class AllAddressAdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView userName;
        private TextView userPhone;
        private TextView context;
        private TextView type;
        private TextView time;

        public AllAddressAdapterViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.item_user_name);
            userPhone = (TextView) itemView.findViewById(R.id.item_car_phone);
            context = (TextView) itemView.findViewById(R.id.item_car_details);
            type = (TextView) itemView.findViewById(R.id.item_car_type);
            time = (TextView) itemView.findViewById(R.id.item_car_time);

        }
    }

    /**
     * 刷新列表
     */
    public void refreshList(List<CarDetails> list) {
        dataList.clear();
        dataList.addAll(list);
        notifyDataSetChanged();//通知全局刷新
    }



    private void bindFooterView(FooterItemViewHolder viewHolder) {
        mNoMore = viewHolder.tvNoMore;
    }


    public static class FooterItemViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNoMore;

        public FooterItemViewHolder(View itemView) {
            super(itemView);
            tvNoMore = (TextView) itemView.findViewById(R.id.tv_footer_no_more);
        }
    }


    /**
     * 获取点击的 item,如果是最后一个,则返回 null
     */
    public CarDetails getClickItem(int position) {
        if (position < dataList.size()) {
            return dataList.get(position);
        } else {
            return null;
        }
    }


}
