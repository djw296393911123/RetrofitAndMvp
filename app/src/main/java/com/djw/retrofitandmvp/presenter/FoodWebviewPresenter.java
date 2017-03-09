package com.djw.retrofitandmvp.presenter;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.contracts.FoodWebviewContracts;
import com.djw.retrofitandmvp.model.FoodWebviewModel;
import com.djw.retrofitandmvp.model.NewsWebviewModel;
import com.djw.retrofitandmvp.model.data.FoodWebviewData;
import com.djw.retrofitandmvp.model.data.NewsWebviewData;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class FoodWebviewPresenter implements FoodWebviewContracts.Presenter {

    private FoodWebviewContracts.View view;

    private FoodWebviewModel model;

    public FoodWebviewPresenter(FoodWebviewContracts.View view) {
        this.view = view;
        this.model = new FoodWebviewModel();
    }

    @Override
    public void LoadData(int id) {
        model.LoadData(new OnRequestDataListener() {
            @Override
            public void onSuccessful(Object o) {
                view.getData(((FoodWebviewData) o));
            }

            @Override
            public void onFali() {

            }

            @Override
            public void onComplete() {

            }
        },id);
    }

    @Override
    public void start() {

    }
}
