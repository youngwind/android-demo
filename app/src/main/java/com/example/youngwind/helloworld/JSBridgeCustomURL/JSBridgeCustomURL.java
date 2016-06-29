package com.example.youngwind.helloworld.JSBridgeCustomURL;

import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.youngwind.helloworld.R;

public class JSBridgeCustomURL extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsbridge_custom_url);

        // 添加了chrome:inspect bebug功能
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (0 != (getApplicationInfo().flags &= ApplicationInfo.FLAG_DEBUGGABLE)) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
        }

        final WebView myWebView = (WebView) findViewById(R.id.webView);

        // webview启用javascript
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        myWebView.loadUrl("file:///android_asset/CustomUrl.html");

        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("wyjs://")) {
                    String methodName = "";
                    String param = "";
                    Uri uri = Uri.parse(url);

                    // toast
                    methodName = uri.getHost();

                    // msg参数
                    param = uri.getQuery();

                    if (methodName.equals("toast")) {
                        Toast.makeText(view.getContext(), param, Toast.LENGTH_LONG).show();
                    }

                    return true;

                }
                return false;
            }
        });
    }
}
