package com.example.youngwind.helloworld;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class BasicUIWidget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_uiwidget);


        // 弹出确认对话框
        findViewById(R.id.showAlertDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(BasicUIWidget.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Something important!");

                // 不能通过back删除确认框
                dialog.setCancelable(false);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(BasicUIWidget.this, "tap confirm", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(BasicUIWidget.this, "tap cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
            }
        });


        // 弹出loading....
        findViewById(R.id.showProgressDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog = new ProgressDialog(BasicUIWidget.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("Loading....");
                progressDialog.setCancelable(true);
                progressDialog.show();

                // 建立定时器,3s后关闭loading...
                final Handler handler = new Handler();
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.hide();
                    }
                };

                handler.postDelayed(runnable, 3000);
            }
        });
    }
}
