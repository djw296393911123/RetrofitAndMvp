package com.djw.retrofitandmvp.base;

/**
 * Created by JasonDong on 2017/3/3.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
}
