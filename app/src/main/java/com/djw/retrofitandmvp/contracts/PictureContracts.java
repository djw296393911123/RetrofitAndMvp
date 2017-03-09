package com.djw.retrofitandmvp.contracts;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.base.BaseModel;
import com.djw.retrofitandmvp.base.BasePresenter;
import com.djw.retrofitandmvp.base.BaseView;
import com.djw.retrofitandmvp.model.data.PictureTypeData;

/**
 * Created by JasonDong on 2017/3/6.
 */

public interface PictureContracts {

    interface View extends BaseView<NewsContracts.Presenter> {
        void getData(PictureTypeData data);
    }

    interface Presenter extends BasePresenter {
        void LoadData();
    }

    interface Model extends BaseModel {
        void LoadData(OnRequestDataListener listener);
    }
}
