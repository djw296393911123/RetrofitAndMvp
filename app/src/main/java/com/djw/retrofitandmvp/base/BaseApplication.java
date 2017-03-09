package com.djw.retrofitandmvp.base;

import android.app.Application;
import android.os.Environment;

import com.djw.retrofitandmvp.Retrofit.util.SPUtils;

import java.io.File;

/**
 * Created by JasonDong on 2017/2/20.
 */
public class BaseApplication extends Application {

    private static BaseApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        SPUtils.init(this, "carinfo");
        DISK_CACHE_PATH();
    }

    public static BaseApplication getInstance() {
        return application;
    }

    private File DISK_CACHE_PATH() {
        File file = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            file = this.getExternalCacheDir();
        } else {
            file = this.getCacheDir();
        }

        if (file != null) {
            String path = file.getPath();
        } else {
            file = new File("/");
        }
//        Log.d(TAG, "filePath = " + path);
//
        SPUtils.putString("cachePath", file.getPath());

        return file;
    }
}
