package com.djw.retrofitandmvp.model;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.Retrofit.util.RetrofitUtil;
import com.djw.retrofitandmvp.contracts.PictureContracts;
import com.djw.retrofitandmvp.model.data.PictureTypeData;

import rx.Subscriber;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class PictureModel implements PictureContracts.Model {
    @Override
    public void LoadData(final OnRequestDataListener listener) {
        RetrofitUtil.getInstance().getPictureTab(new Subscriber<PictureTypeData>() {
            @Override
            public void onCompleted() {
                listener.onComplete();
            }

            @Override
            public void onError(Throwable e) {
                listener.onFali();
            }

            @Override
            public void onNext(PictureTypeData data) {
                listener.onSuccessful(data);
            }
        });
    }
}
