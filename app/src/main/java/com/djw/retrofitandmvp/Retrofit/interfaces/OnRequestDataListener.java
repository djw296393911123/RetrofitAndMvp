package com.djw.retrofitandmvp.Retrofit.interfaces;

/**
 * Created by JasonDong on 2017/3/3.
 */

public interface OnRequestDataListener<T> {
    void onSuccessful(T t);

    void onFali();

    void onComplete();
}
