package com.example.lenovo.testing;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import android.os.Handler;

/**
 * Created by manish on 01-04-2018.
 */

public class TimeService extends Service {
    MainActivity ma = new MainActivity();
    // constant
    public static final long NOTIFY_INTERVAL = 10 * 1000; // 10 seconds

    // run on another Thread to avoid crash
    private Handler mHandler = new Handler();
    // timer handling
    private Timer mTimer = null;
   // List<Integer> workerList = new ArrayList<Integer>();
    LinearLayout linearMain;
    CheckBox checkBox;
    LinkedHashMap<String, String> alphabet = new LinkedHashMap<String, String>();
    List<Integer> workerList = new ArrayList<Integer>();
   // NotificationCompat.Builder notification;
    private static final int uniqueID2 = 45614;
    int count, min, hr;
    String t;
    String nextTime;
    List<Integer> countFn = new ArrayList<Integer>();
    int nextMin, curMin, call;
    Random random;
    public int m;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        // cancel if already existed
//        if (mTimer != null) {
//            mTimer.cancel();
//        } else {
//            // recreate new
//            mTimer = new Timer();
//        }
//        // schedule task
//        mTimer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 0, NOTIFY_INTERVAL);
        workerList.add(1);
        workerList.add(2);
        workerList.add(3);
        workerList.add(4);
        workerList.add(5);
        workerList.add(6);
        workerList.add(7);
        workerList.add(8);
        workerList.add(10);
        first_last();

    }



//    class TimeDisplayTimerTask extends TimerTask {
//
//        @Override
//        public void run() {
//            // run on another thread
//            mHandler.post(new Runnable() {
//
//                @Override
//                public void run() {
//                    // display toast
//                    first_last();
//                    Toast.makeText(getApplicationContext(), getDateTime(),
//                            Toast.LENGTH_SHORT).show();
//                    //first_last();
//                }
//
//            });
//        }
////
//        private String getDateTime() {
//            // get date time in custom format
//            SimpleDateFormat sdf = new SimpleDateFormat("[yyyy/MM/dd - HH:mm:ss]");
//            return sdf.format(new Date());
//        }
//
//    }
    public void first_last() {
        m = 0;
        t = getCurrentTime();
        min = (t.charAt(3) - 48) * 10 + (t.charAt(4) - 48);
        hr = (t.charAt(0) - 48) * 10 + (t.charAt(1) - 48);

        min = min + 15;
        if (min > 59) {
            if (hr == 23)
                hr = 0;
            else
                hr = hr + 1;
            min = min - 60;
        }

        nextMin = hr * 60 + min;

        count =workerList.size();
        randomId();

    }

    public void middle() {
        m = 1;
        random = new Random();

        int index, wid, c = 0, callTime;

        while (c < call) {
            index = random.nextInt(count);
            wid =workerList.get(index);
            callTime = random.nextInt(7) * 20;
            t = getCurrentTime();
            min = (t.charAt(3) - 48) * 10 + (t.charAt(4) - 48);
            hr = (t.charAt(0) - 48) * 10 + (t.charAt(1) - 48);
            min = min + callTime;
            while (min > 59) {
                hr = hr + 1;
                min = min - 60;
            }

            if (hr <= 9 && min <= 9)
                nextTime = "0" + hr + ":" + "0" + min;

            else if (min <= 9)
                nextTime = hr + ":" + "0" + min;
            else if (hr <= 9)
                nextTime = "0" + hr + ":" + min;
            else
                nextTime = hr + ":" + min;

            while (true) {
                if (nextTime.equals(getCurrentTime())) {
                    notifySupri(wid);
                    break;
                }
            }

            c++;
        }


        first_last();
    }

    public void randomId() {
        t = getCurrentTime();
        min = (t.charAt(3) - 48) * 10 + (t.charAt(4) - 48);
        hr = (t.charAt(0) - 48) * 10 + (t.charAt(1) - 48);
        curMin = hr * 60 + min;
        if (nextMin > curMin) {
            Log.d("vivz", "random id called");
            Random random = new Random();

            int index = random.nextInt(count);
            int wid = workerList.get(index);
            Log.d("vivz", wid + "called");

            if (countFn.contains(wid)) {
                randomId();
            }
            countFn.add(wid);
            notifySupri(wid);
            // sleep for 10 seconds after every call for first and last 15 minutes.
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            randomId();
        }
        else {
            call = random.nextInt(3);
            middle();
        }
    }

    public void notifySupri(int wid) {
        //notification.setSmallIcon(R.drawable.enigma);
//        notification.setTicker("verification notice");
//        notification.setWhen(System.currentTimeMillis());
 //       notification.setContentTitle("verification notice");
 //        notification.setPriority(Notification.PRIORITY_MAX);
//        notification.setContentText("call worker :" + wid);
 //       notification.setDefaults(Notification.DEFAULT_SOUND);

//        Intent intent = new Intent(this,Verification.class);
//        startActivity(intent);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        notification.setContentIntent(pendingIntent);
//        NotificationManager nm = (NotificationManager) getSystemService(Service.NOTIFICATION_SERVICE);
//        nm.notify(uniqueID2, notification.build());
//
//        NotificationManager notificationManager =
//                (NotificationManager) getSystemService(Service.NOTIFICATION_SERVICE);
//        Notification notification = new Notification(internalSetBigContentTitle("call worket"));
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        notification.setContentIntent(pendingIntent);
//        notificationManager.notify(uniqueID2, notification);
        Intent intent = new Intent(this, Verification.class);

        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT );

        Notification n  = new Notification.Builder(this)
                //.setContentTitle("New mail from " + "test@gmail.com")
               // .setContentText("Subject")
                .setSmallIcon(R.drawable.enigma)
 //       notification.setSmallIcon(R.drawable.enigma);
          .setTicker("verification notice")
           .setWhen(System.currentTimeMillis())
           .setContentTitle("verification notice")
             .setPriority(Notification.PRIORITY_MAX)
              .setContentText("call worker :" + wid)
              .setDefaults(Notification.DEFAULT_SOUND).setContentIntent(pIntent).build();
                //.setAutoCancel(true).build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Service.NOTIFICATION_SERVICE);

        notificationManager.notify(0, n);
        startActivity(intent);

    }


    String getCurrentTime()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String currentTime = dateFormat.format(System.currentTimeMillis());
        return currentTime;
    }
}