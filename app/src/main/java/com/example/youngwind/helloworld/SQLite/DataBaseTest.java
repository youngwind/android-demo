package com.example.youngwind.helloworld.SQLite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.youngwind.helloworld.R;

public class DataBaseTest extends AppCompatActivity {


    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_test);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 1);
        findViewById(R.id.create_database).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });
    }
}
