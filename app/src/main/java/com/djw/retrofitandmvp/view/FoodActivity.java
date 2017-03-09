package com.djw.retrofitandmvp.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.djw.retrofitandmvp.R;
import com.djw.retrofitandmvp.base.BaseActivity;
import com.djw.retrofitandmvp.contracts.FoodWebviewContracts;
import com.djw.retrofitandmvp.contracts.NewsContracts;
import com.djw.retrofitandmvp.contracts.NewsWebviewContracts;
import com.djw.retrofitandmvp.model.data.FoodWebviewData;
import com.djw.retrofitandmvp.model.data.NewsWebviewData;
import com.djw.retrofitandmvp.presenter.FoodWebviewPresenter;
import com.djw.retrofitandmvp.presenter.NewsWebviewPresenter;

public class FoodActivity extends BaseActivity implements FoodWebviewContracts.View {

    private WebView webview;
    private ProgressBar progressBar;

    @Override
    protected void initData() {
        FoodWebviewPresenter presenter = new FoodWebviewPresenter(this);
        presenter.LoadData(getIntent().getIntExtra("id", 1));
    }

    @Override
    protected void initViews() {
        webview = (WebView) findViewById(R.id.wv_web);
        progressBar = (ProgressBar) findViewById(R.id.myProgressBar);
    }

    @Override
    protected void initParms(Bundle bundle) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
    }

    @Override
    public void getData(final FoodWebviewData data) {
        Log.i("data--------------->" , data.toString());
        webview.loadUrl(data.getUrl());
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(data.getUrl());
                return true;
            }
        });
        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                // TODO Auto-generated method stub
                super.onReceivedTitle(view, title);
            }
        });
        webview.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    progressBar.setVisibility(View.INVISIBLE);
                } else {
                    if (View.INVISIBLE == progressBar.getVisibility()) {
                        progressBar.setVisibility(View.VISIBLE);
                    }
                    progressBar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

        });
    }

    @Override
    public void setPresenter(NewsContracts.Presenter presenter) {

    }
}
