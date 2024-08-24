package com.motiky.themeui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CardView extends AppCompatActivity {

    private static final String CHANNEL_ID = "MyChannel";
    private  static  final int NOTIFICATION_ID = 97;
    private static final int REQ_CODE = 97;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_card_view);


        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.my_app_logo, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(bitmap)
                    .setSmallIcon(R.drawable.my_app_logo)
                    .setContentText("New message from CardViewActivity")
                    .setSubText("New message")
                    .setChannelId(CHANNEL_ID)
                    .build();
            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "New channel", NotificationManager.IMPORTANCE_HIGH));
        } else{
            notification = new Notification.Builder(this)
                    .setLargeIcon(bitmap)
                    .setSmallIcon(R.drawable.my_app_logo)
                    .setContentText("New message from CardViewActivity")
                    .setSubText("New message")
                    .build();
        }
        notificationManager.notify(NOTIFICATION_ID, notification);
    }

    public void handleOnClickPrev(View view){
        Intent iPrev = new Intent(view.getContext(), MainActivity.class);
        startActivity(iPrev);
    }

    public void handleOnClickNext(View view){
        Intent iPrev = new Intent(view.getContext(), RecycleView.class);
        startActivity(iPrev);
    }


}