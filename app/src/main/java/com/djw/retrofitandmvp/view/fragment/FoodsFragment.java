package com.djw.retrofitandmvp.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.djw.retrofitandmvp.R;
import com.djw.retrofitandmvp.adapter.FoodContentAdapter;
import com.djw.retrofitandmvp.base.BaseFragment;
import com.djw.retrofitandmvp.contracts.FoodContentContracts;
import com.djw.retrofitandmvp.contracts.NewsContracts;
import com.djw.retrofitandmvp.model.data.FoodsData;
import com.djw.retrofitandmvp.presenter.FoodPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodsFragment extends BaseFragment implements FoodContentContracts.View, SwipeRefreshLayout.OnRefreshListener {


    private boolean isLoadViewSuccess = false;
    private SwipeRefreshLayout swipeRefreshLayout;
    private FoodPresenter presenter;
    private FoodContentAdapter adapter;

    public FoodsFragment() {
        // Required empty public constructor
    }

    public static FoodsFragment newInstance(int position) {

        Bundle args = new Bundle();
        args.putInt("position", position);
        FoodsFragment fragment = new FoodsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void lazyLoad() {
        if (!isLoadViewSuccess || !isVisible)
            return;
        presenter.LoadData(getArguments().getInt("position"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        isLoadViewSuccess = true;
        return inflater.inflate(R.layout.fragment_foods, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_food);
        swipeRefreshLayout = ((SwipeRefreshLayout) view.findViewById(R.id.srl_food));
        swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new FoodContentAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        presenter = new FoodPresenter(this);
        lazyLoad();
    }

    @Override
    public void getData(FoodsData data) {
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
}
