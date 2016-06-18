package com.example.youngwind.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

public class LearnRecyclerView extends AppCompatActivity {


    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rv = new RecyclerView(this);
        setContentView(rv);

        rv.setLayoutManager(new LinearLayoutManager(this));

        rv.setAdapter(new RecyclerView.Adapter() {


            class ViewHolder extends RecyclerView.ViewHolder {

                private TextView tv;

                public ViewHolder(TextView itemView) {
                    super(itemView);

                    tv = itemView;
                }

                public TextView getTv() {
                    return tv;
                }
            }

            // 创建
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new ViewHolder(new TextView(parent.getContext()));
            }


            // 对每一项进行赋值
            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ViewHolder vh = (ViewHolder) holder;
                vh.getTv().setText(position + data[position]);

            }

            // item数量
            @Override
            public int getItemCount() {
                return data.length;
            }

            private String[] data = new String[]{
                    "liangshaofeng",
                    "Hello",
                    "world !",
                    "What are you doing?",
                    "I am coding.",
                    "Why you want to learn Android?",
                    "Because I want to develop an App"

            };
        });

    }
}
