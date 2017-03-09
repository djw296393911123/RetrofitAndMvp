package com.djw.retrofitandmvp.view.fragment;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.bumptech.glide.Glide;
import com.djw.retrofitandmvp.R;
import com.djw.retrofitandmvp.Retrofit.util.ImagePager;
import com.djw.retrofitandmvp.adapter.PicturePageAdapter;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends DialogFragment {

    private int position;
    private ArrayList<String> urls;
    private List<View> views;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        position = bundle.getInt("position");
        urls = bundle.getStringArrayList("urls");
        initPager();
    }

    private void initPager() {
        views = new ArrayList<>();
        for (int i = 0; i < urls.size(); i++) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_page, null);
            PhotoView photoView = (PhotoView) view.findViewById(R.id.pv_item);
            photoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
                @Override
                public void onPhotoTap(View view, float x, float y) {
                    dismiss();
                }
            });
            Glide.with(getActivity()).load(urls.get(i)).into(photoView);
            views.add(view);
        }
    }

    public static PageFragment newInstance(List<String> urls, int position) {

        Bundle args = new Bundle();
        args.putInt("position",position);
        args.putStringArrayList("urls", (ArrayList<String>) urls);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.page_layout, null);
        ImagePager pager = (ImagePager) view.findViewById(R.id.pager);
        pager.setAdapter(new PicturePageAdapter(views));
        pager.setCurrentItem(position);
        AlertDialog alertDialog = new AlertDialog
                .Builder(getActivity(), android.R.style.Theme_DeviceDefault_NoActionBar_Fullscreen)
                .setView(view)
                .create();
        Window window = alertDialog.getWindow();
        window.setWindowAnimations(R.style.dialog_style);
        return alertDialog;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        System.gc();
//        Glide.get(BaseApplication.getInstance()).clearMemory();
    }
}
