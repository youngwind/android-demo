package com.example.youngwind.helloworld;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SendNotification extends AppCompatActivity {

    private int count = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_notification);


        // 设置点击通知栏的动作
        Intent intent = new Intent(this, SendNotification.class);
        final PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        // 设置点击通知栏之后通知栏消失
        NotificationManager manager0 = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager0.cancel(count);

        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification noti = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    noti = new Notification.Builder(view.getContext())
                            .setContentTitle("新的通知标题" + count)
                            .setContentText("新的通知内容" + count)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentIntent(pi)
                            .build();
                }

                manager.notify(count, noti);
                count++;
            }
        });
    }


}
