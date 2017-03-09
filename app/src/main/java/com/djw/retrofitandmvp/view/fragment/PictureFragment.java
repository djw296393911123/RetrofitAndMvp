package com.djw.retrofitandmvp.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.djw.retrofitandmvp.R;
import com.djw.retrofitandmvp.adapter.PictureTabAdapter;
import com.djw.retrofitandmvp.base.BaseFragment;
import com.djw.retrofitandmvp.contracts.NewsContracts;
import com.djw.retrofitandmvp.contracts.PictureContracts;
import com.djw.retrofitandmvp.model.data.PictureTypeData;
import com.djw.retrofitandmvp.presenter.PicturePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends BaseFragment implements PictureContracts.View {


    private TabLayout tabLayout;
    private ViewPager pager;
    private List<String> list = new ArrayList<>();
    private PicturePresenter presenter;
    private PictureTabAdapter adapter;

    public PictureFragment() {
        // Required empty public constructor
    }

    @Override
    protected void lazyLoad() {

    }

    public static PictureFragment newInstance(int position) {

        Bundle args = new Bundle();
        args.putInt("position", position);
        PictureFragment fragment = new PictureFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_picture, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = ((TabLayout) view.findViewById(R.id.tl_girl));
        pager = ((ViewPager) view.findViewById(R.id.vp_girl));
        tabLayout.setupWithViewPager(pager);
        adapter = new PictureTabAdapter(getChildFragmentManager(), list);
        pager.setAdapter(adapter);
        presenter = new PicturePresenter(this);
        presenter.start();
    }

    @Override
    public void getData(PictureTypeData data) {
        List<PictureTypeData.TngouBean> tngou = data.getTngou();
        for (int i = 0; i < tngou.size(); i++) {
            list.add(tngou.get(i).getTitle());
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(NewsContracts.Presenter presenter) {

    }
}
