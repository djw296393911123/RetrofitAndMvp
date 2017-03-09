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
import com.djw.retrofitandmvp.adapter.FoodTabAdapter;
import com.djw.retrofitandmvp.contracts.FoodContracts;
import com.djw.retrofitandmvp.contracts.NewsContracts;
import com.djw.retrofitandmvp.model.data.FoodTypeData;
import com.djw.retrofitandmvp.presenter.FoodTypePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodTabFragment extends Fragment implements FoodContracts.View {

    private List<FoodTypeData.TngouBean> list = new ArrayList<>();
    private FoodTypePresenter presenter;
    private FoodTabAdapter adapter;

    public FoodTabFragment() {
        // Required empty public constructor
    }

    public static FoodTabFragment newInstance(int position) {

        Bundle args = new Bundle();
        args.putInt("position", position);
        FoodTabFragment fragment = new FoodTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tl_food);
        ViewPager pager = (ViewPager) view.findViewById(R.id.vp_food);
        tabLayout.setupWithViewPager(pager);
        adapter = new FoodTabAdapter(getChildFragmentManager(), list);
        pager.setAdapter(adapter);
        presenter = new FoodTypePresenter(this);
        presenter.start();
    }

    @Override
    public void getData(FoodTypeData data) {
        list.clear();
        list.addAll(data.getTngou());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(NewsContracts.Presenter presenter) {

    }
}
