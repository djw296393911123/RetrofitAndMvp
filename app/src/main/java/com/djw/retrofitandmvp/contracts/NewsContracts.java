package com.djw.retrofitandmvp.contracts;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.base.BaseModel;
import com.djw.retrofitandmvp.base.BasePresenter;
import com.djw.retrofitandmvp.base.BaseView;
import com.djw.retrofitandmvp.model.data.NewsTypeData;

import java.util.List;

/**
 * Created by JasonDong on 2017/3/3.
 */

public interface NewsContracts {

    interface View extends BaseView<Presenter> {
        void getData(List<NewsTypeData.TngouBean> list);
    }

    interface Presenter extends BasePresenter {
        void LoadData();
    }

    interface Model extends BaseModel {
        void LoadData(OnRequestDataListener listener);
    }

}
