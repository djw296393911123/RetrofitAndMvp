package com.djw.retrofitandmvp.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.djw.retrofitandmvp.R;
import com.djw.retrofitandmvp.adapter.MainPagerAdapter;
import com.djw.retrofitandmvp.base.BaseActivity;
import com.djw.retrofitandmvp.view.fragment.FirstFragment;
import com.djw.retrofitandmvp.view.fragment.FoodTabFragment;
import com.djw.retrofitandmvp.view.fragment.PictureFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    private ViewPager pager;
    private BottomNavigationBar bar;
    private List<Fragment> fragments;

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fragments.add(FirstFragment.newInstance(0));
        fragments.add(PictureFragment.newInstance(1));
        fragments.add(FoodTabFragment.newInstance(2));
        pager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(),fragments));
        pager.addOnPageChangeListener(this);
        pager.setEnabled(false);
        bar.selectTab(0);
    }

    @Override
    protected void initViews() {
        pager = (ViewPager) findViewById(R.id.vp_main);
        bar = (BottomNavigationBar) findViewById(R.id.bnb_main);
        bar.setMode(BottomNavigationBar.MODE_FIXED);
        bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bar
                .addItem(new BottomNavigationItem(R.drawable.ic_assessment_black_24dp, "新闻"))
                .addItem(new BottomNavigationItem(R.drawable.ic_local_activity_black_24dp, "图片"))
                .addItem(new BottomNavigationItem(R.drawable.ic_receipt_black_24dp, "菜谱"))
                .initialise();
        bar.setTabSelectedListener(this);

    }

    @Override
    protected void initParms(Bundle bundle) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackEnable(false);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onTabSelected(int position) {
        pager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
