package com.example.youngwind.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.nio.BufferUnderflowException;

public class MainActivity extends AppCompatActivity {

    private TextView homeTown;

    // 创建activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("A onCreate");

        // 定义打开my_layout视图
        setContentView(R.layout.my_layout);

        homeTown = (TextView) findViewById(R.id.hometown);

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

                // 一般的打开新activity
                //startActivity(i);

                // 打开新activity,并且监听返回值
                startActivityForResult(i, 1);

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // requestCode 为请求码,代表此activity要请求的数据的意义
        // resultCode 为返回码,代表后一个activity给此activity返回数据的状态码
        // 这里务必要进行if判断,否则用户直接点击回退的时候,会因为data为空而报错
        if (requestCode == 1 && resultCode == 200) {
            homeTown.setText("另一个activity返回的数据是:" + data.getStringExtra("data"));
        }
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
