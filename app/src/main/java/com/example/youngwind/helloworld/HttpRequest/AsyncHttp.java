package com.example.youngwind.helloworld.HttpRequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.youngwind.helloworld.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

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
                asynhttpGet("http://www.baidu.com");
            }
        });
    }

    private void asynhttpGet(String url) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                getResponse.setText(new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
