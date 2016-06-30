package com.example.youngwind.helloworld.JSBridgeAlert;

import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.youngwind.helloworld.R;

public class JSBridgeAlert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsbridge_alert);
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


        myWebView.loadUrl("file:///android_asset/alert.html");

        myWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {

                // url === "fiel:///"
                // message === "ywjs://toast?利用jsAlert建立JSBridge"

                if(message.startsWith("ywjs://")){
                    String methodName = "";
                    String param = "";
                    Uri uri = Uri.parse(message);

                    // toast
                    methodName = uri.getHost();

                    // msg参数
                    param = uri.getQuery();

                    if (methodName.equals("toast")) {
                        Toast.makeText(view.getContext(), param, Toast.LENGTH_LONG).show();
                    }
                    // 这一句非常关键,相当于点击了alert的确认
                    // 没有这一句的话,alert只能被触发一次,且其他地方的alert也不能被触发
                    result.confirm();
                }



                return true;
            }
        });
    }
}
