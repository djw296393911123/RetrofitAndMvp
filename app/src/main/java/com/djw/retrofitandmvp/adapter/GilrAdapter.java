package com.djw.retrofitandmvp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
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
import com.djw.retrofitandmvp.model.data.GirlData;
import com.djw.retrofitandmvp.model.data.NewsContentData;
import com.djw.retrofitandmvp.view.WebViewActivity;
import com.djw.retrofitandmvp.view.fragment.PageFragment;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class GilrAdapter extends RecyclerView.Adapter<GilrAdapter.NewsContentHolder> {

    private Context context;

    private List<GirlData.TngouBean> list;

    private List<String> urls;

    public GilrAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
        this.urls = new ArrayList<>();
    }

    public void notifyListDataChange(List<GirlData.TngouBean> list, boolean isLoadMore) {
        if (!isLoadMore) this.list.clear();
        this.list.addAll(list);
        for (int i = 0; i < list.size(); i++) {
            urls.add(ApiRequest.IMG_URL + list.get(i).getImg());
        }
        notifyDataSetChanged();
    }

    @Override
    public NewsContentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsContentHolder(LayoutInflater.from(context).inflate(R.layout.girl_item, parent, false));
    }

    @Override
    public void onBindViewHolder(NewsContentHolder holder, final int position) {
        Glide.with(context).load(ApiRequest.IMG_URL + list.get(position).getImg()).asBitmap().placeholder(R.mipmap.img_default_meizi).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
                transaction.add(PageFragment.newInstance(urls, position), "img");
                transaction.commitAllowingStateLoss();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NewsContentHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final CardView cardView;

        public NewsContentHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
            imageView = ((ImageView) itemView.findViewById(R.id.iv_girl));
            cardView = ((CardView) itemView.findViewById(R.id.cv_item));
        }
    }
}
