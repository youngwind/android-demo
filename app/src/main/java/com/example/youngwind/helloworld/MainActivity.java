package com.example.youngwind.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // 程序从这儿开始执行
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        // 绑定自定义视图,activity与视图layout的关系
        // ?如何自定义activity
        setContentView(R.layout.my_layout);

        findViewById(R.id.btnStartAnotherAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 跳转到另一个activity
                startActivity(new Intent(MainActivity.this, AnotherAty.class));

                // 跳转到网页
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com")));
            }
        });

    }
}
