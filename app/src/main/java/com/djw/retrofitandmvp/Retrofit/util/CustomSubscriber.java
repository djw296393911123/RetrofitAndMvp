package com.djw.retrofitandmvp.Retrofit.util;

import com.djw.retrofitandmvp.model.data.BaseResponse;

import rx.functions.Func1;

/**
 * Created by JasonDong on 2017/3/7.
 */

public class CustomSubscriber<T> implements Func1<BaseResponse<T>, T> {


    @Override
    public T call(BaseResponse<T> tBaseResponse) {
       return null;
    }


}
