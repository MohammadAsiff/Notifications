package com.example.utsav.notification;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.but1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Simple Notification")
                        .setContentText("This is Text of Notification");
                NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0,builder.build());
            }
        });
        findViewById(R.id.but2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pintent=PendingIntent.getActivity(MainActivity.this, (int) Calendar.getInstance().getTimeInMillis(),intent,0);
                NotificationCompat.InboxStyle inboxStyle=new NotificationCompat.InboxStyle();
                inboxStyle.setBigContentTitle("Inbox Notification");
                inboxStyle.addLine("Message 1.");
                inboxStyle.addLine("Message 2.");
                  inboxStyle.addLine("Message 3.");
                inboxStyle.addLine("Message 4.");
                inboxStyle.addLine("Message 5.");
                inboxStyle.setSummaryText("+2 more");
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Inbox style Notification")
                        .setContentText("This is Text of Inbox Notification")
                        .setStyle(inboxStyle)
                        .addAction(R.mipmap.ic_launcher,"show activity",pintent);
                NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0,builder.build());
            }
        });
        findViewById(R.id.but3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap pic= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher );
                NotificationCompat.BigTextStyle bigTextStyle=new NotificationCompat.BigTextStyle();
                bigTextStyle.bigText("Our team consists of highly passionate and enthusiastic researchers and practitioners from IIT Kanpur and other top universities that empowers Government and Non Government Organisations to improve the lives of millions of people by solving problems at the grassroot level. Since 2015 we have been working with education and are gradually expanding into Healthcare and other sectors…");
                bigTextStyle.setBigContentTitle("Big Text Notification");
                bigTextStyle.setSummaryText("By:Promorph");
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("BigText Notification")
                        .setContentText("This is Text of Big text style Notification")
                        .setLargeIcon(pic)
                        .setStyle(bigTextStyle);
                NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0,builder.build());


            }
        });
        findViewById(R.id.but4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.BigPictureStyle bpStyle = new NotificationCompat.BigPictureStyle();
                bpStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.promorph)).build();
                Intent rIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://promorph.in/"));
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, rIntent, 0);
                NotificationCompat.Builder mBuilder =  new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Big Picture Notification Example")
                        .addAction(R.mipmap.ic_launcher, "Share", pendingIntent)
                        .setStyle(bpStyle);

                mBuilder.setContentIntent(pendingIntent);
                int mNotificationId = 001;
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(mNotificationId, mBuilder.build());
            }
        });
    }
}
