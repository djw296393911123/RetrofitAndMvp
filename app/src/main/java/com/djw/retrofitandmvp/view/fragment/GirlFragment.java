package com.djw.retrofitandmvp.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.djw.retrofitandmvp.R;
import com.djw.retrofitandmvp.adapter.GilrAdapter;
import com.djw.retrofitandmvp.adapter.NewsContentAdapter;
import com.djw.retrofitandmvp.base.BaseFragment;
import com.djw.retrofitandmvp.contracts.GirlContracts;
import com.djw.retrofitandmvp.contracts.NewsContentContracts;
import com.djw.retrofitandmvp.contracts.NewsContracts;
import com.djw.retrofitandmvp.model.data.GirlData;
import com.djw.retrofitandmvp.model.data.NewsContentData;
import com.djw.retrofitandmvp.presenter.GirlPresenter;
import com.djw.retrofitandmvp.presenter.NewsContentPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class GirlFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, GirlContracts.View {

    private SwipeRefreshLayout swipeRefreshLayout;
    private GilrAdapter adapter;
    private GirlPresenter presenter;
    private boolean isLoadViewSuccess = false;

    public GirlFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        isLoadViewSuccess = true;
        return inflater.inflate(R.layout.fragment_girl, container, false);
    }

    public static GirlFragment newInstance(int position) {

        Bundle args = new Bundle();
        args.putInt("position", position);
        GirlFragment fragment = new GirlFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_girl);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        adapter = new GilrAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout = ((SwipeRefreshLayout) view.findViewById(R.id.srl_girl));
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(this);
        presenter = new GirlPresenter(this);
        lazyLoad();
    }

    @Override
    public void getData(GirlData data) {
        adapter.notifyListDataChange(data.getTngou(), false);
    }

    @Override
    public void showRefreshView() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideRefreshView() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onFail() {
        Toast.makeText(getActivity(), "数据加载失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(NewsContracts.Presenter presenter) {
    }

    @Override
    public void onRefresh() {
        presenter.LoadData(getArguments().getInt("position"));
    }

    @Override
    protected void lazyLoad() {
        if (!isLoadViewSuccess || !isVisible)
            return;
        presenter.LoadData(getArguments().getInt("position"));
    }
}
