package com.example.youngwind.helloworld.JSBridgeJavaScriptInterface;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by youngwind on 16/6/29.
 */
public class JSHandler {

    public Context context;

    public JSHandler(Context c) {
        this.context = c;
    }

    @JavascriptInterface
    public void toast(String msg) {
        Toast.makeText(this.context, msg, Toast.LENGTH_LONG).show();
    }
}
