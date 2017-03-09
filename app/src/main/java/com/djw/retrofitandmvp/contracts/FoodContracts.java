package com.djw.retrofitandmvp.contracts;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.base.BaseModel;
import com.djw.retrofitandmvp.base.BasePresenter;
import com.djw.retrofitandmvp.base.BaseView;
import com.djw.retrofitandmvp.model.data.FoodTypeData;

/**
 * Created by JasonDong on 2017/3/6.
 */

public interface FoodContracts {

    interface View extends BaseView<NewsContracts.Presenter> {
        void getData(FoodTypeData data);
    }

    interface Presenter extends BasePresenter {
        void LoadData();
    }

    interface Model extends BaseModel {
        void LoadData(OnRequestDataListener listener);
    }
}
