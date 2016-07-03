package com.example.youngwind.helloworld.ThreadTask;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.youngwind.helloworld.R;

public class ThreadChangeUI extends AppCompatActivity {

    public static final int UPDATE_TEXT = 1;
    private TextView text;


    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    // 在这里可以进行UI操作
                    text.setText("Oh my god!我被改变了!");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_change_ui);

        text = (TextView) findViewById(R.id.text);

        findViewById(R.id.changeUI).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handler.sendMessage(message);  // 发送Message对象
                    }
                }).start();
            }
        });
    }
}
