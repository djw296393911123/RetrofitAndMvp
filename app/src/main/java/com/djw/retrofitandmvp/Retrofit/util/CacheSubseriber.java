package com.djw.retrofitandmvp.Retrofit.util;

import com.djw.retrofitandmvp.Retrofit.interfaces.ApiRequest;
import com.djw.retrofitandmvp.base.BaseApplication;

import rx.Subscriber;

/**
 * Created by JasonDong on 2017/3/8.
 */

public class CacheSubseriber<T> extends Subscriber<T> {

    @Override
    public void onStart() {
        super.onStart();
        if (!NetUtils.isConnected(BaseApplication.getInstance().getApplicationContext()) && !NetUtils.isWifi(BaseApplication.getInstance().getApplicationContext())) {
        }
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }
}
