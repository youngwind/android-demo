package com.example.youngwind.helloworld.HttpRequest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.youngwind.helloworld.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpRequest extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_request);

        text = (TextView) findViewById(R.id.httpGetReponse);

        // 设置点击按钮发起http get请求
        findViewById(R.id.httpGet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadUrl("https://www.baidu.com");
            }
        });
    }

    public void ReadUrl(String url) {
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... arg0) {
                try {
                    URL url = new URL(arg0[0]);
                    System.out.print(url);
                    URLConnection connection = url.openConnection();
                    InputStream iStream = connection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(iStream);
                    BufferedReader br = new BufferedReader(isr);
                    String line;
                    StringBuilder builder = new StringBuilder();
                    while ((line = br.readLine()) != null) {
                        builder.append(line);
                    }
                    br.close();
                    iStream.close();
                    return builder.toString();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            // 返回成功之后回调函数
            @Override
            protected void onPostExecute(String result) {
                text.setText(result);
            }


        }.execute(url);
    }
}
