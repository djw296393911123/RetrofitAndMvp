package com.djw.retrofitandmvp.presenter;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.contracts.FoodContentContracts;
import com.djw.retrofitandmvp.model.FoodModel;
import com.djw.retrofitandmvp.model.data.FoodsData;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class FoodPresenter implements FoodContentContracts.Presenter {

    private FoodContentContracts.View view;

    private FoodModel model;

    public FoodPresenter(FoodContentContracts.View view) {
        this.view = view;
        this.model = new FoodModel();
    }

    @Override
    public void LoadData(int id) {
        view.showRefreshView();
        model.LoadData(id, new OnRequestDataListener() {
            @Override
            public void onSuccessful(Object o) {
                view.getData(((FoodsData) o));
            }

            @Override
            public void onFali() {
                view.hideRefreshView();
                view.onFail();

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
