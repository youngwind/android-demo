package com.example.youngwind.helloworld.SQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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

        // 插入数据
        findViewById(R.id.add_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();

                // 组装数据
                values.put("name", "Android Guide Book");
                values.put("author", "liangshaofeng");
                values.put("pages", 454);
                values.put("price", 16.96);
                db.insert("Book", null, values);

                Toast.makeText(view.getContext(), "add data succeded", Toast.LENGTH_SHORT).show();
            }
        });

        // 更新数据
        findViewById(R.id.update_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 10.99);
                db.update("Book", values, "author = ?", new String[]{"liangshaofeng"});
                Toast.makeText(view.getContext(), "update data succeded", Toast.LENGTH_SHORT).show();
            }
        });


        // 删除数据
        findViewById(R.id.delete_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Book", "pages > ?", new String[]{"300"});
                Toast.makeText(view.getContext(), "delete data succeded", Toast.LENGTH_SHORT).show();
            }
        });

        // 查询数据
        findViewById(R.id.query_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                // 查询Book表中所有的数据
                Cursor cursor = db.query("Book", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        // 遍历Cursor对象,取出数据并打印
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("DatabaseTest", "book name is " + name);
                        Log.d("DatabaseTest", "book author is " + author);
                        Log.d("DatabaseTest", "book pages is " + pages);
                        Log.d("DatabaseTest", "book price is " + price);
                    } while (cursor.moveToNext());
                }
                cursor.close();
                Toast.makeText(view.getContext(), "The result is print on the logcat of android monitor", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
