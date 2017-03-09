package com.djw.retrofitandmvp.presenter;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.contracts.NewsContracts;
import com.djw.retrofitandmvp.model.NewsModel;
import com.djw.retrofitandmvp.model.data.NewsTypeData;

import java.util.List;

/**
 * Created by JasonDong on 2017/3/3.
 */

public class NewsPresenter implements NewsContracts.Presenter {

    private NewsContracts.View view;

    private NewsModel model;

    public NewsPresenter(NewsContracts.View view) {
        this.view = view;
        this.model = new NewsModel();
    }

    @Override
    public void start() {
        LoadData();
    }

    @Override
    public void LoadData() {
        model.LoadData(new OnRequestDataListener() {
            @Override
            public void onSuccessful(Object o) {
                view.getData(((List<NewsTypeData.TngouBean>) o));
            }

            @Override
            public void onFali() {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
