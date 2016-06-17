package com.example.youngwind.helloworld;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnotherAty extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_aty);
        System.out.println("B onCreate");
        tv = (TextView) findViewById(R.id.tv);

        // 数据解析
        Intent i = getIntent();
        Bundle data = i.getExtras();

        tv.setText(String.format("name=%s, age=%d", data.getString("name"), data.getInt("age")));


    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("B onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("B onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("B onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("B onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("B onDestory");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("B onRestart");
    }
}
