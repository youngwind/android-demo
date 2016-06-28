package com.example.youngwind.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class TestWebView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_web_view);

        WebView myWebView = (WebView) findViewById(R.id.myWebView);

        // 控制webview中的网页跳转依然在webview中打开
        myWebView.setWebViewClient(new WebViewClient());


        myWebView.loadUrl("https://www.baidu.com");
    }
}
