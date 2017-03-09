package com.djw.retrofitandmvp.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.djw.retrofitandmvp.R;
import com.djw.retrofitandmvp.adapter.NewTabAdapter;
import com.djw.retrofitandmvp.contracts.NewsContracts;
import com.djw.retrofitandmvp.model.data.NewsTypeData;
import com.djw.retrofitandmvp.presenter.NewsPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements NewsContracts.View {


    private ViewPager pager;
    private TabLayout tabLayout;
    private NewsPresenter presenter;
    private List<String> list = new ArrayList<>();
    private NewTabAdapter adapter;

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(int position) {

        Bundle args = new Bundle();
        args.putInt("position", position);
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pager = ((ViewPager) view.findViewById(R.id.vp_all));
        tabLayout = ((TabLayout) view.findViewById(R.id.tl_all));
        tabLayout.setupWithViewPager(pager);
        adapter = new NewTabAdapter(getChildFragmentManager(), list);
        pager.setAdapter(adapter);
        presenter = new NewsPresenter(this);
        presenter.start();
    }

    @Override
    public void getData(List<NewsTypeData.TngouBean> list) {
        Log.i("list----->", "sdfasd");
        this.list.clear();
        for (int i = 0; i < list.size(); i++) {
            this.list.add(list.get(i).getName());
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(NewsContracts.Presenter presenter) {
//        this.presenter.start();
    }
}
