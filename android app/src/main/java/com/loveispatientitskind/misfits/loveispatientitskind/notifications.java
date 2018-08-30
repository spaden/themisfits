package com.loveispatientitskind.misfits.loveispatientitskind;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class notifications extends Service {
    String[] quotes={"Lets be each others kids darling, what do you say?","She was like an other mom to me","I can never repay my wife, her love was inevitable",
            "Shyla, please dont leave me. I need you more than I need myself right now","Baby, happy birthday and lets kiss each other like its our last",
               "I was never really a husband/family material type of guy until I met her","I am a narcissist and a alcoholic","Nootropics, a mind enhancing drug",
                "Wanna get high?","Lets do molly/mdma, even though its illegal","Lets get filthy rich","Wanna be my CO-CEO","Kumar, someday you are gonna realize your mistakes",
                 "Shyla? Why are you in love with a insane guy like me?","I have a split condition, there is an other me too","Are you both married towards each other?","Friends dont do stuff like that",
                "Kumar you have a very bad body odour","Baby lets stay here forever"};

    @Nullable
    @Override

    public IBinder onBind(Intent intent) {
        return null;
    }
    class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            Random rand = new Random();

            int  tt = rand.nextInt(quotes.length-1) + 1;
            Intent intent = new Intent(notifications.this, splashscreen.class);
            PendingIntent pIntent = PendingIntent.getActivity(notifications.this, 0, intent, 0);

// build notification
// the addAction re-use the same intent to keep the example short
            /*Notification n = new NotificationCompat.Builder(notifications.this, "testads")
                    .setSmallIcon(R.mipmap.ad)
                    .setContentTitle("Quotes from my book")
                    .setContentText("read")
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText(quotes[tt]))
                    .build();*/
            final Notification.Builder builder = new Notification.Builder(notifications.this);
            builder.setStyle(new Notification.BigTextStyle(builder)
                    .bigText(quotes[tt])
                    .setBigContentTitle("Quotes from my book")
                    .setSummaryText("continue reading"))
                    .setContentTitle("Hey there")
                    .setContentText(" ")
                    .setSmallIcon(android.R.drawable.sym_def_app_icon);
            builder.setContentIntent(pIntent);
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            notificationManager.notify(0, builder.build());

        }
    }
   @Override
    public int onStartCommand(Intent intent,int flags,int StartId){
        Timer timer=new Timer();
        MyTimerTask myTimerTask=new MyTimerTask();
        timer.schedule(myTimerTask,10000,7200000);
        // timer.schedule(myTimerTask,10000,30000);
       return START_STICKY;
   }
}
