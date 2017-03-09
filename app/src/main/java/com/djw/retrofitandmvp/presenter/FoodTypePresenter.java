package com.djw.retrofitandmvp.presenter;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.contracts.FoodContracts;
import com.djw.retrofitandmvp.model.FoodTypeModel;
import com.djw.retrofitandmvp.model.data.FoodTypeData;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class FoodTypePresenter implements FoodContracts.Presenter {

    private FoodContracts.View view;

    private FoodTypeModel model;

    public FoodTypePresenter(FoodContracts.View view) {
        this.view = view;
        this.model = new FoodTypeModel();
    }

    @Override
    public void LoadData() {
        model.LoadData(new OnRequestDataListener() {
            @Override
            public void onSuccessful(Object o) {
                view.getData(((FoodTypeData) o));
            }

            @Override
            public void onFali() {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void start() {
        LoadData();
    }
}
