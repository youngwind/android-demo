package com.example.youngwind.helloworld;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ThreadAndAsyncTask extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_and_async_task);

        mContext = ThreadAndAsyncTask.this;
        // 点击按钮阻塞主进程5s
        findViewById(R.id.blockThread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Thread.sleep(3000);
                    Toast.makeText(view.getContext(), "3s过去啦", Toast.LENGTH_SHORT).show();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });

        // 点击按钮新开进程,不会阻塞进程
        findViewById(R.id.newThread).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                new Thread() {
                    public void run() {
                        try {
                            sleep(3000);

                            // Looper更多的用法有待研究
                            Looper.prepare();
                            Toast.makeText(mContext, "3s过去啦", Toast.LENGTH_SHORT).show();
                            Looper.loop();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
    }
}
