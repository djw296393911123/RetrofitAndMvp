package com.djw.retrofitandmvp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.djw.retrofitandmvp.R;
import com.djw.retrofitandmvp.Retrofit.interfaces.ApiRequest;
import com.djw.retrofitandmvp.model.data.FoodsData;
import com.djw.retrofitandmvp.model.data.NewsContentData;
import com.djw.retrofitandmvp.view.FoodActivity;
import com.djw.retrofitandmvp.view.WebViewActivity;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class FoodContentAdapter extends RecyclerView.Adapter<FoodContentAdapter.NewsContentHolder> {

    private Context context;

    private List<FoodsData.TngouBean> list;

    public FoodContentAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    public void notifyListDataChange(List<FoodsData.TngouBean> list, boolean isLoadMore) {
        if (!isLoadMore) this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public NewsContentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsContentHolder(LayoutInflater.from(context).inflate(R.layout.food_item, parent, false));
    }

    @Override
    public void onBindViewHolder(NewsContentHolder holder, final int position) {
        holder.textView.setText(list.get(position).getDescription());
        holder.name.setText(list.get(position).getName());
        Glide.with(context).load(ApiRequest.IMG_URL + list.get(position).getImg()).asBitmap().into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, FoodActivity.class).putExtra("id", list.get(position).getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NewsContentHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView textView;
        private final CardView cardView;
        private final TextView name;

        public NewsContentHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
            imageView = ((ImageView) itemView.findViewById(R.id.iv_food));
            textView = ((TextView) itemView.findViewById(R.id.tv_food_title));
            cardView = ((CardView) itemView.findViewById(R.id.cv_item));
            name = ((TextView) itemView.findViewById(R.id.tv_food_name));
        }
    }
}
