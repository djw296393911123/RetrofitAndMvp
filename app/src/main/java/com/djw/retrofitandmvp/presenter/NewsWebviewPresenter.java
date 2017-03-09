package com.djw.retrofitandmvp.presenter;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.contracts.NewsWebviewContracts;
import com.djw.retrofitandmvp.model.NewsWebviewModel;
import com.djw.retrofitandmvp.model.data.NewsWebviewData;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class NewsWebviewPresenter implements NewsWebviewContracts.Presenter {

    private NewsWebviewContracts.View view;

    private NewsWebviewModel model;

    public NewsWebviewPresenter(NewsWebviewContracts.View view) {
        this.view = view;
        this.model = new NewsWebviewModel();
    }

    @Override
    public void LoadData(int id) {
        model.LoadData(new OnRequestDataListener() {
            @Override
            public void onSuccessful(Object o) {
                view.getData(((NewsWebviewData) o));
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
