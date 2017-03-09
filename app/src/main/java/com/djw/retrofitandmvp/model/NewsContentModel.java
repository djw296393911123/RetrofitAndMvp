package com.djw.retrofitandmvp.model;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.Retrofit.util.RetrofitUtil;
import com.djw.retrofitandmvp.contracts.NewsContentContracts;
import com.djw.retrofitandmvp.model.data.NewsContentData;

import rx.Subscriber;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class NewsContentModel implements NewsContentContracts.Model {

    @Override
    public void LoadData(int id,final OnRequestDataListener listener) {
        RetrofitUtil.getInstance().getNewsContent(new Subscriber<NewsContentData>() {
            @Override
            public void onCompleted() {
                listener.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                listener.onFali();
            }

            @Override
            public void onNext(NewsContentData newsContentData) {
                listener.onSuccessful(newsContentData);
            }
        }, id);
    }
}
