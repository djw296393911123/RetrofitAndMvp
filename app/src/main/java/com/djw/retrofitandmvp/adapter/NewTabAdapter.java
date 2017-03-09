package com.djw.retrofitandmvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.djw.retrofitandmvp.view.fragment.NewsFragment;

import java.util.List;

/**
 * Created by JasonDong on 2017/3/3.
 */

public class NewTabAdapter extends FragmentPagerAdapter {
    private List<String> list;

    public NewTabAdapter(FragmentManager fm, List<String> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return NewsFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
