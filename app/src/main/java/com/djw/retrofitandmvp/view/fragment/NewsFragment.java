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
import com.djw.retrofitandmvp.adapter.NewsContentAdapter;
import com.djw.retrofitandmvp.base.BaseFragment;
import com.djw.retrofitandmvp.contracts.NewsContentContracts;
import com.djw.retrofitandmvp.contracts.NewsContracts;
import com.djw.retrofitandmvp.model.data.NewsContentData;
import com.djw.retrofitandmvp.presenter.NewsContentPresenter;

import java.util.List;

/**
 * Created by JasonDong on 2017/3/3.
 */

public class NewsFragment extends BaseFragment implements NewsContentContracts.View, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private NewsContentAdapter adapter;
    private NewsContentPresenter presenter;
    private boolean isLoadViewSuccess = false;

    public static NewsFragment newInstance(int position) {

        Bundle args = new Bundle();
        args.putInt("position", position);
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        isLoadViewSuccess = true;
        return inflater.inflate(R.layout.fragment_news, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_news);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new NewsContentAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout = ((SwipeRefreshLayout) view.findViewById(R.id.srl_news));
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(this);
        presenter = new NewsContentPresenter(this);
        lazyLoad();
    }

    @Override
    public void getData(NewsContentData data) {
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
