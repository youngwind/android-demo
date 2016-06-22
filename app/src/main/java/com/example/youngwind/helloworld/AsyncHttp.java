package com.example.youngwind.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

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
                asynhttpGet("http://172.24.28.97:3000/test");
            }
        });
    }

    private void asynhttpGet(String url) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                Toast.makeText(AsyncHttp.this, responseBody,Toast.LENGTH_LONG);
                System.out.println(statusCode);
                System.out.println(headers);
                System.out.println(new String(responseBody));
                getResponse.setText(new String(responseBody));
                JSONArray array = JSON.parseArray(new String(responseBody));
                System.out.print(array);
                
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
