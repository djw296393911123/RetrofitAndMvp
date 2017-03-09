package com.djw.retrofitandmvp.Retrofit.util;

import com.djw.retrofitandmvp.Retrofit.interfaces.ApiRequest;
import com.djw.retrofitandmvp.model.data.FoodTypeData;
import com.djw.retrofitandmvp.model.data.FoodWebviewData;
import com.djw.retrofitandmvp.model.data.FoodsData;
import com.djw.retrofitandmvp.model.data.GirlData;
import com.djw.retrofitandmvp.model.data.NewsContentData;
import com.djw.retrofitandmvp.model.data.NewsTypeData;
import com.djw.retrofitandmvp.model.data.NewsWebviewData;
import com.djw.retrofitandmvp.model.data.PictureTypeData;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by JasonDong on 2017/3/3.
 */

public class RetrofitUtil {
    private static final int DEFAULT_TIMEOUT = 5;
    private ApiRequest apiServices;

    private static RetrofitUtil mInstance;

    private RetrofitUtil() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        Retrofit mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(ApiRequest.SERVICE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        apiServices = mRetrofit.create(ApiRequest.class);
    }

    public static RetrofitUtil getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitUtil.class) {
                mInstance = new RetrofitUtil();
            }
        }
        return mInstance;
    }

    public void getNewsTab(Subscriber<NewsTypeData> subscriber) {
        apiServices.getNewsType().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    public void getNewsContent(Subscriber<NewsContentData> subscriber, int id) {
        apiServices.getNewsContent(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    public void getWebview(Subscriber<NewsWebviewData> subscriber, int id) {
        apiServices.getWebview(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    public void getPictureTab(Subscriber<PictureTypeData> subscriber) {
        apiServices.getPictureType().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    public void getGirl(Subscriber<GirlData> subscriber, int id) {
        apiServices.getGirl(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    public void getFoodTab(Subscriber<FoodTypeData> subscriber) {
        apiServices.getFoodType().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    public void getFoodContent(Subscriber<FoodsData> subscriber, int id) {
        apiServices.getFoodContent(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

    public void getFoodWebview(Subscriber<FoodWebviewData> subscriber, int id) {
        apiServices.getFoodWebview(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
    }

}
