package com.djw.retrofitandmvp.model;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.Retrofit.util.RetrofitUtil;
import com.djw.retrofitandmvp.contracts.GirlContracts;
import com.djw.retrofitandmvp.model.data.GirlData;

import rx.Subscriber;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class GirlModel implements GirlContracts.Model {

    @Override
    public void LoadData(int id, final OnRequestDataListener listener) {
        RetrofitUtil.getInstance().getGirl(new Subscriber<GirlData>() {
            @Override
            public void onCompleted() {
                listener.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                listener.onFali();
            }

            @Override
            public void onNext(GirlData girlData) {
                listener.onSuccessful(girlData);
            }
        }, id);
    }
}
