package com.example.youngwind.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.nio.BufferUnderflowException;

public class MainActivity extends AppCompatActivity {

    // 创建activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("A onCreate");

        // 定义打开my_layout视图
        setContentView(R.layout.my_layout);

        /**
         * 给按btnStartAnotherAty添加点击事件
         */
        findViewById(R.id.btnStartAnotherAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 跳转到另一个activity
                startActivity(new Intent(MainActivity.this, AnotherAty.class));
            }
        });


        /**
         * 给按钮btnStartWWWPage添加点击事件
         */
        findViewById(R.id.btnStartWWWPage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 跳转到网页
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com")));
            }
        });

        findViewById(R.id.newActivityAndTransferParams).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 跳转到另一个activity,并且传递参数过去
                Intent i = new Intent(MainActivity.this, AnotherAty.class);

                // 组织复杂数据结构
                Bundle b = new Bundle();
                b.putString("name", "liangshaofeng");
                b.putInt("age", 23);
                i.putExtras(b);

                startActivity(i);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("A onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("A onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("A onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("A onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("A onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("A onRestart");
    }
}
