package com.djw.retrofitandmvp.contracts;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.base.BaseModel;
import com.djw.retrofitandmvp.base.BasePresenter;
import com.djw.retrofitandmvp.base.BaseView;
import com.djw.retrofitandmvp.model.data.GirlData;
import com.djw.retrofitandmvp.model.data.NewsContentData;

/**
 * Created by JasonDong on 2017/3/6.
 */

public interface GirlContracts {

    interface View extends BaseView<NewsContracts.Presenter> {

        void getData(GirlData data);

        void showRefreshView();

        void hideRefreshView();

        void onFail();

    }

    interface Presenter extends BasePresenter {

        void LoadData(int id);

    }

    interface Model extends BaseModel {
        void LoadData(int id,OnRequestDataListener listener);
    }
}
