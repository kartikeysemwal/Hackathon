package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Locale;

public class CurrentAffairsPage extends AppCompatActivity {

    String wview = String.valueOf(R.string.show);
    private WebView webView;
    private ProgressBar spinner;
    Intent intent;
    String lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        lang = intent.getStringExtra("lang");
        setAppLocale(lang);
        setContentView(R.layout.activity_current_affairs_page);

        webView = (WebView) findViewById(R.id.webview);

        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        webView.setWebViewClient(new CustomWebViewClient());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        if(lang.charAt(0)=='h')
            webView.loadUrl("https://www.amarujala.com/");
        else
        {
            webView.loadUrl("https://timesofindia.indiatimes.com/");
        }
    }

    private class CustomWebViewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView webview, String url, Bitmap favicon) {
            if (wview.equals( String.valueOf(R.string.show))) {
                webview.setVisibility(webview.INVISIBLE);
            }
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            wview =  String.valueOf(R.string.hide);
            spinner.setVisibility(View.GONE);
            view.setVisibility(webView.VISIBLE);
            super.onPageFinished(view, url);
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle( String.valueOf(R.string.close));
        builder.setMessage( String.valueOf(R.string.wantToLeave));
        builder.setPositiveButton( String.valueOf(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.setNegativeButton( String.valueOf(R.string.discard), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                CurrentAffairsPage.super.onBackPressed();
            }
        });
        builder.show();
    }

    private void setAppLocale(String localeCode)
    {
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
        {
            conf.setLocale(new Locale(localeCode.toLowerCase()));
        }
        else
        {
            conf.locale = new Locale(localeCode.toLowerCase());
        }
        res.updateConfiguration(conf, dm);
    }
}
