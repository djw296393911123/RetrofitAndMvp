package com.djw.retrofitandmvp.Retrofit.util;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by JasonDong on 2017/3/8.
 */

public class CacheUtils {

    /**
     * 保存到SD卡
     * @param filename
     * @param filecontent
     * @throws Exception
     */
    public static void saveToSDCard(String filename, String filecontent)throws Exception{
        File file = new File(SPUtils.getString(SPUtils.DISK_CACHE_NAME, Environment.getExternalStorageDirectory().getAbsolutePath()),filename);
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream outStream = new FileOutputStream(file);
        outStream.write(filecontent.getBytes());
        outStream.close();
    }
}
