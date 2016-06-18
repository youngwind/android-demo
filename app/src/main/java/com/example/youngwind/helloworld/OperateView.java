package com.example.youngwind.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class OperateView extends AppCompatActivity {

    private LinearLayout ll;
    private Button btnAddedByJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operate_view);

        // 获得layout对象
        ll = (LinearLayout) findViewById(R.id.operateView);

        btnAddedByJava = new Button(this);
        btnAddedByJava.setText("这个按钮是用java动态生成的,点我我就会被移除哦~");
        ll.addView(btnAddedByJava);

        // 添加点击删除事件
        btnAddedByJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll.removeView(btnAddedByJava);
            }
        });
    }
}
