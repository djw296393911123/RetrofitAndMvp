package com.djw.retrofitandmvp.model;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.Retrofit.util.CacheUtils;
import com.djw.retrofitandmvp.Retrofit.util.RetrofitUtil;
import com.djw.retrofitandmvp.contracts.NewsContracts;
import com.djw.retrofitandmvp.model.data.NewsTypeData;
import com.google.gson.Gson;

import rx.Subscriber;

/**
 * Created by JasonDong on 2017/3/3.
 */

public class NewsModel implements NewsContracts.Model {

    @Override
    public void LoadData(final OnRequestDataListener listener) {
        RetrofitUtil.getInstance().getNewsTab(new Subscriber<NewsTypeData>() {
            @Override
            public void onCompleted() {
                listener.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                listener.onFali();
            }

            @Override
            public void onNext(NewsTypeData newsTypeData) {
                listener.onSuccessful(newsTypeData.getTngou());
            }
        });
    }
}
