package com.djw.retrofitandmvp.model;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.Retrofit.util.RetrofitUtil;
import com.djw.retrofitandmvp.contracts.NewsWebviewContracts;
import com.djw.retrofitandmvp.model.data.NewsWebviewData;

import rx.Subscriber;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class NewsWebviewModel implements NewsWebviewContracts.Model {
    @Override
    public void LoadData(final OnRequestDataListener listener, int id) {
        RetrofitUtil.getInstance().getWebview(new Subscriber<NewsWebviewData>() {
            @Override
            public void onCompleted() {
                listener.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                listener.onFali();
            }

            @Override
            public void onNext(NewsWebviewData data) {
                listener.onSuccessful(data);
            }
        }, id);
    }
}
