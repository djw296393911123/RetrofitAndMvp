package com.djw.retrofitandmvp.presenter;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.contracts.NewsContentContracts;
import com.djw.retrofitandmvp.model.NewsContentModel;
import com.djw.retrofitandmvp.model.data.NewsContentData;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class NewsContentPresenter implements NewsContentContracts.Presenter {

    private NewsContentContracts.View view;

    private NewsContentModel model;

    public NewsContentPresenter(NewsContentContracts.View view) {
        this.view = view;
        this.model = new NewsContentModel();
    }

    @Override
    public void LoadData(int id) {
        view.showRefreshView();
        model.LoadData(id,new OnRequestDataListener() {
            @Override
            public void onSuccessful(Object o) {
                view.getData(((NewsContentData) o));
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
