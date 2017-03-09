package com.djw.retrofitandmvp.Retrofit.interfaces;

import com.djw.retrofitandmvp.model.data.FoodTypeData;
import com.djw.retrofitandmvp.model.data.FoodWebviewData;
import com.djw.retrofitandmvp.model.data.FoodsData;
import com.djw.retrofitandmvp.model.data.GirlData;
import com.djw.retrofitandmvp.model.data.NewsContentData;
import com.djw.retrofitandmvp.model.data.NewsTypeData;
import com.djw.retrofitandmvp.model.data.NewsWebviewData;
import com.djw.retrofitandmvp.model.data.PictureTypeData;

import retrofit2.http.GET;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by JasonDong on 2017/3/3.
 */

public interface ApiRequest {

    String IMG_URL = "http://tnfs.tngou.net/image";

    String SERVICE = "http://www.tngou.net/";

    @GET("api/top/classify")
    Observable<NewsTypeData> getNewsType();

    @GET("api/top/list")
    Observable<NewsContentData> getNewsContent(@Query("id") int id);

    @GET("api/top/show")
    Observable<NewsWebviewData> getWebview(@Query("id") int id);

    @GET("tnfs/api/classify")
    Observable<PictureTypeData> getPictureType();

    @GET("tnfs/api/list")
    Observable<GirlData> getGirl(@Query("id") int id);

    @GET("api/cook/classify")
    Observable<FoodTypeData> getFoodType();

    @GET("api/cook/list")
    Observable<FoodsData> getFoodContent(@Query("id") int id);

    @GET("/api/cook/show")
    Observable<FoodWebviewData> getFoodWebview(@Query("id") int id);

}
