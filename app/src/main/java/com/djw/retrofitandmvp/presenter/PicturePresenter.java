package com.djw.retrofitandmvp.presenter;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.contracts.PictureContracts;
import com.djw.retrofitandmvp.model.PictureModel;
import com.djw.retrofitandmvp.model.data.PictureTypeData;

/**
 * Created by JasonDong on 2017/3/6.
 */

public class PicturePresenter implements PictureContracts.Presenter {

    private PictureContracts.View view;

    private PictureModel model;

    public PicturePresenter(PictureContracts.View view) {
        this.view = view;
        this.model = new PictureModel();
    }

    @Override
    public void LoadData() {
        model.LoadData(new OnRequestDataListener() {
            @Override
            public void onSuccessful(Object o) {
                view.getData(((PictureTypeData) o));
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
