package com.example.youngwind.helloworld;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ThreadAndAsyncTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_and_async_task);

        // 点击按钮阻塞主进程5s
        findViewById(R.id.blockThread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Thread.sleep(5000);
                    System.out.println("5s过去啦");
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
                            sleep(5000);
                            System.out.println("5s过去啦");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });
    }
}
