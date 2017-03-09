package com.djw.retrofitandmvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.djw.retrofitandmvp.model.data.FoodTypeData;
import com.djw.retrofitandmvp.view.fragment.FoodsFragment;
import com.djw.retrofitandmvp.view.fragment.GirlFragment;

import java.util.List;

/**
 * Created by JasonDong on 2017/3/3.
 */

public class FoodTabAdapter extends FragmentPagerAdapter {
    private List<FoodTypeData.TngouBean> list;

    public FoodTabAdapter(FragmentManager fm, List<FoodTypeData.TngouBean> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return FoodsFragment.newInstance(list.get(position).getId());
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getTitle();
    }
}
