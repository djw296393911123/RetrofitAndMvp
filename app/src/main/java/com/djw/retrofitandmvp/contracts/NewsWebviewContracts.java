package com.djw.retrofitandmvp.contracts;

import com.djw.retrofitandmvp.Retrofit.interfaces.OnRequestDataListener;
import com.djw.retrofitandmvp.base.BaseModel;
import com.djw.retrofitandmvp.base.BasePresenter;
import com.djw.retrofitandmvp.base.BaseView;
import com.djw.retrofitandmvp.model.data.NewsTypeData;
import com.djw.retrofitandmvp.model.data.NewsWebviewData;

import java.util.List;

/**
 * Created by JasonDong on 2017/3/6.
 */

public interface NewsWebviewContracts {

    interface View extends BaseView<NewsContracts.Presenter> {
        void getData(NewsWebviewData data);
    }

    interface Presenter extends BasePresenter {
        void LoadData(int id);
    }

    interface Model extends BaseModel {
        void LoadData(OnRequestDataListener listener, int id);
    }

}
