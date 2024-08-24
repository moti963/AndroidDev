package com.motiky.dyapp.MyActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.motiky.dyapp.R;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;
    Button youtube, portfolio, google, devserver, github1s;
    String YOUTUBE_URL = "https://www.youtube.com/";
    String PORTFOLIO_URL = "https://motiky.pythonanywhere.com/";
    String GOOGLE_URL = "https://www.google.com";
    String DEV_URL = "https://dev.ottermap.com/";
    String GITHUB_1S = "https://github1s.com/";

    ProgressBar progressBar;
    LinearLayout button_cont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.web_view);
        progressBar = findViewById(R.id.progress_bar);
        button_cont = findViewById(R.id.button_cont);

        youtube = findViewById(R.id.youtube);
        google = findViewById(R.id.google);
        portfolio = findViewById(R.id.portfolio);
        devserver = findViewById(R.id.devserver);
        github1s = findViewById(R.id.github);

        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNewWebView(YOUTUBE_URL);
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNewWebView(GOOGLE_URL);
            }
        });

        portfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNewWebView(PORTFOLIO_URL);
            }
        });

        devserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNewWebView(DEV_URL);
            }
        });

        github1s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNewWebView(GITHUB_1S);
            }
        });
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void loadNewWebView(String base_url) {
        button_cont.setVisibility(View.GONE);
        webView.loadUrl(base_url);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            /*@Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }*/

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressBar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressBar.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
                super.onPageFinished(view, url);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}