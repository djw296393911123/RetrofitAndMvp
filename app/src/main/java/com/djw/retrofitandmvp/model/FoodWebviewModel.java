package com.djw.retrofitandmvp.model;

import com.bumptech.glide.load.Key;
import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.Retrofit.util.RetrofitUtil;
import com.djw.retrofitandmvp.contracts.FoodWebviewContracts;
import com.djw.retrofitandmvp.model.data.FoodWebviewData;

import rx.Subscriber;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class FoodWebviewModel implements FoodWebviewContracts.Model {
    @Override
    public void LoadData(final OnRequestDataListener listener, int id) {
        RetrofitUtil.getInstance().getFoodWebview(new Subscriber<FoodWebviewData>() {
            @Override
            public void onCompleted() {
                listener.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                listener.onFali();
            }

            @Override
            public void onNext(FoodWebviewData foodWebviewData) {
                listener.onSuccessful(foodWebviewData);
            }
        }, id);
    }
}
