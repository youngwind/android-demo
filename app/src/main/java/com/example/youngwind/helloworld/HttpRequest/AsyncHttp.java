package com.example.youngwind.helloworld.HttpRequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.youngwind.helloworld.R;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.lang.reflect.Array;
import java.util.Arrays;

import cz.msebera.android.httpclient.Header;

// 使用android-async-http库
public class AsyncHttp extends AppCompatActivity {

    private TextView getResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_http);
        getResponse = (TextView) findViewById(R.id.getResponse);

        findViewById(R.id.startGetRequest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                asynhttpGet("http://apis.baidu.com/txapi/weixin/wxhot?num=10");
            }
        });
    }


    private void asynhttpGet(String url) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.addHeader("apiKey", "2c25fe0184c7cb0b54c813eae914ad7b");
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                getResponse.setText(response);
                Log.d("response", response);

                // 使用Gson解析json数据
                Gson gson = new Gson();
                Newslist newslist = gson.fromJson(response, Newslist.class);
                Log.d("response", String.valueOf(newslist.code));
                Log.d("response", newslist.msg);
                Log.d("response", String.valueOf(newslist.newslist[0].ctime));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("fai", new String(responseBody));
            }
        });
    }
}
