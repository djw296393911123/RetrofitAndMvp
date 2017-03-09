package com.djw.retrofitandmvp.model;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.Retrofit.util.RetrofitUtil;
import com.djw.retrofitandmvp.contracts.FoodContentContracts;
import com.djw.retrofitandmvp.model.data.FoodsData;

import rx.Subscriber;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class FoodModel implements FoodContentContracts.Model {
    @Override
    public void LoadData(int id, final OnRequestDataListener listener) {
        RetrofitUtil.getInstance().getFoodContent(new Subscriber<FoodsData>() {
            @Override
            public void onCompleted() {
                listener.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                listener.onFali();
            }

            @Override
            public void onNext(FoodsData foodsData) {
                listener.onSuccessful(foodsData);
            }
        }, id);
    }
}
