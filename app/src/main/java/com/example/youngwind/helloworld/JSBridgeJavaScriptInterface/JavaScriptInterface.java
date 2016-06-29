package com.example.youngwind.helloworld.JSBridgeJavaScriptInterface;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.youngwind.helloworld.*;

public class JavaScriptInterface extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_script_interface);

        // 添加了chrome:inspect bebug功能
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (0 != (getApplicationInfo().flags &= ApplicationInfo.FLAG_DEBUGGABLE)) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
        }

        WebView myWebView = (WebView) findViewById(R.id.webView);

        // webview启用javascript
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // 控制webview中的网页跳转依然在webview中打开
        myWebView.setWebViewClient(new WebViewClient());


        myWebView.loadUrl("file:///android_asset/JavaScriptInterface.html");

        myWebView.addJavascriptInterface(new JSHandler(this), "YWJS");

    }
}
