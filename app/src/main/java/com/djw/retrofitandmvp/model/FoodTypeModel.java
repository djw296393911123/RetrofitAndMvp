package com.djw.retrofitandmvp.model;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.Retrofit.util.RetrofitUtil;
import com.djw.retrofitandmvp.contracts.FoodContracts;
import com.djw.retrofitandmvp.model.data.FoodTypeData;

import rx.Subscriber;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class FoodTypeModel implements FoodContracts.Model {
    @Override
    public void LoadData(final OnRequestDataListener listener) {
        RetrofitUtil.getInstance().getFoodTab(new Subscriber<FoodTypeData>() {
            @Override
            public void onCompleted() {
                listener.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                listener.onFali();
            }

            @Override
            public void onNext(FoodTypeData foodTypeData) {
                listener.onSuccessful(foodTypeData);
            }
        });
    }
}
