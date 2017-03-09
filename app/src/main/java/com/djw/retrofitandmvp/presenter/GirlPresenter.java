package com.djw.retrofitandmvp.presenter;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.contracts.GirlContracts;
import com.djw.retrofitandmvp.model.GirlModel;
import com.djw.retrofitandmvp.model.data.GirlData;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class GirlPresenter implements GirlContracts.Presenter {

    private GirlContracts.View view;

    private GirlModel model;

    public GirlPresenter(GirlContracts.View view) {
        this.view = view;
        this.model = new GirlModel();
    }

    @Override
    public void LoadData(int id) {
        view.showRefreshView();
        model.LoadData(id, new OnRequestDataListener() {
            @Override
            public void onSuccessful(Object o) {
                view.getData(((GirlData) o));
            }

            @Override
            public void onFali() {
                view.hideRefreshView();
            }

            @Override
            public void onComplete() {
                view.hideRefreshView();
            }
        });
    }

    @Override
    public void start() {

    }
}
