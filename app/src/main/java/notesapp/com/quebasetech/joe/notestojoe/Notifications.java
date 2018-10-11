package notesapp.com.quebasetech.joe.notestojoe;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notifications extends AppCompatActivity {
    private Button simpleNotification, bigStyleNotification;
    private NotificationManager notificationManager;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        simpleNotification = (Button) findViewById(R.id.simpleNotification);
        bigStyleNotification = (Button) findViewById(R.id.bigStyleNotification);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        setupActions();
    }

    private void setupActions() {
        simpleNotification.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                intent = new Intent(Notifications.this, Notifications_view.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), (int) System.currentTimeMillis(), intent, 0);
                long[] vv = {500, 500};
                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.raw.ember);
                Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle();
                bigPictureStyle.bigPicture(largeIcon);

                Notification notification = new Notification.Builder(Notifications.this)
                        .setContentTitle("New Order")
                        .setContentText("Deliver to room 5 block D 2 cups")
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setLargeIcon(largeIcon)
                        .setSound(uri)
                        .setAutoCancel(true)
                        .setStyle(bigPictureStyle)
                        .setFullScreenIntent(pendingIntent, false)
                        .setVibrate(vv)
                        .setWhen((long) System.currentTimeMillis())
                        .setContentIntent(pendingIntent)
                        .build();
                notificationManager.notify(0, notification);
            }
        });

        bigStyleNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
