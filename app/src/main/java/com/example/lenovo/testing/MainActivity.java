package com.example.lenovo.testing;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends Activity
{
    LinearLayout linearMain;
    CheckBox checkBox;
    LinkedHashMap<String, String> alphabet = new LinkedHashMap<String, String>();
    List<Integer> workerList = new ArrayList<Integer>();
    NotificationCompat.Builder notification;
    private static final int uniqueID2 = 45614;
    int count, min, hr;
    String t;
    String nextTime;
    List<Integer> countFn = new ArrayList<Integer>();
    int nextMin, curMin, call;
    Random random;
    public int m;



    @Override protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            linearMain = (LinearLayout) findViewById(R.id.linearMain);
            /** * create linked hash map for store item you can get value from database * or server also */

            alphabet.put("1", "Apple");
            alphabet.put("2", "Boy");
            alphabet.put("3", "Cat");
            alphabet.put("4", "Dog");
            alphabet.put("5", "Eet");
            alphabet.put("6", "Fat");
            alphabet.put("7", "Goat");
            alphabet.put("8", "Hen");
            alphabet.put("9", "I am");
            alphabet.put("10", "Jug");
            Set<?> set = alphabet.entrySet();
             // Get an iterator
              Iterator<?> i = set.iterator();
              // Display elements
               while (i.hasNext())
               {
                   @SuppressWarnings("rawtypes")
                   Map.Entry me = (Map.Entry) i.next();
                   System.out.print(me.getKey() + ": ");
                   System.out.println(me.getValue());
                   checkBox = new CheckBox(this);
                   checkBox.setId(Integer.parseInt(me.getKey().toString()));
                   checkBox.setText(me.getValue().toString());
                   linearMain.addView(checkBox);
               }
            Button button;
            button = (Button) findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {

                    Toast.makeText(getApplicationContext(), "Attendance Submitted", Toast.LENGTH_SHORT).show();
                    selectItem();
                    startService(new Intent(getApplicationContext(),TimeService.class));
                     //first_last();

                }
            });

//            notification = new NotificationCompat.Builder(this);
//            notification.setAutoCancel(true);
        }

    public void selectItem()
    {
        Set<?> set = alphabet.entrySet();
        Iterator<?> i = set.iterator();


        while (i.hasNext())
        {
            Map.Entry me = (Map.Entry) i.next();
            if (((CheckBox)findViewById(Integer.parseInt(me.getKey().toString()))).isChecked())
            {
                workerList.add(Integer.parseInt(me.getKey().toString()));
                Toast.makeText(getApplicationContext(), Integer.parseInt(me.getKey().toString())+"", Toast.LENGTH_SHORT).show();
            }

        }

    }

//
//    public void first_last() {
//        m = 0;
//        t = getCurrentTime();
//        min = (t.charAt(3) - 48) * 10 + (t.charAt(4) - 48);
//        hr = (t.charAt(0) - 48) * 10 + (t.charAt(1) - 48);
//
//        min = min + 15;
//        if (min > 59) {
//            if (hr == 23)
//                hr = 0;
//            else
//                hr = hr + 1;
//            min = min - 60;
//        }
//
//        nextMin = hr * 60 + min;
//
//        count =workerList.size();
//        randomId();
//
//    }
//
//    public void middle() {
//        m = 1;
//        random = new Random();
//
//        int index, wid, c = 0, callTime;
//
//        while (c < call) {
//            index = random.nextInt(count);
//            wid =workerList.get(index);
//            callTime = random.nextInt(7) * 20;
//            t = getCurrentTime();
//            min = (t.charAt(3) - 48) * 10 + (t.charAt(4) - 48);
//            hr = (t.charAt(0) - 48) * 10 + (t.charAt(1) - 48);
//            min = min + callTime;
//            while (min > 59) {
//                hr = hr + 1;
//                min = min - 60;
//            }
//
//            if (hr <= 9 && min <= 9)
//                nextTime = "0" + hr + ":" + "0" + min;
//
//            else if (min <= 9)
//                nextTime = hr + ":" + "0" + min;
//            else if (hr <= 9)
//                nextTime = "0" + hr + ":" + min;
//            else
//                nextTime = hr + ":" + min;
//
//            while (true) {
//                if (nextTime.equals(getCurrentTime())) {
//                    notifySupri(wid);
//                    break;
//                }
//            }
//
//            c++;
//        }
//
//
//        first_last();
//    }
//
//    public void randomId() {
//        t = getCurrentTime();
//        min = (t.charAt(3) - 48) * 10 + (t.charAt(4) - 48);
//        hr = (t.charAt(0) - 48) * 10 + (t.charAt(1) - 48);
//        curMin = hr * 60 + min;
//        if (nextMin > curMin) {
//            Log.d("vivz", "random id called");
//            Random random = new Random();
//
//            int index = random.nextInt(count);
//            int wid = workerList.get(index);
//            Log.d("vivz", wid + "called");
//
//            if (countFn.contains(wid)) {
//                randomId();
//            }
//            countFn.add(wid);
//            notifySupri(wid);
//            // sleep for 10 seconds after every call for first and last 15 minutes.
//            try {
//                TimeUnit.SECONDS.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            randomId();
//        }
//        else {
//            call = random.nextInt(3);
//            middle();
//        }
//    }
//
//    public void notifySupri(int wid) {
//        notification.setSmallIcon(R.drawable.enigma);
//        notification.setTicker("verification notice");
//        notification.setWhen(System.currentTimeMillis());
//        notification.setContentTitle("verification notice");
//        notification.setPriority(Notification.PRIORITY_MAX);
//        notification.setContentText("call worker :" + wid);
//        notification.setDefaults(Notification.DEFAULT_SOUND);
//
//        Intent intent = new Intent(this,Verification.class);
//        startActivity(intent);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        notification.setContentIntent(pendingIntent);
//        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        nm.notify(uniqueID2, notification.build());
//
//    }
//
//
//    String getCurrentTime()
//    {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
//        String currentTime = dateFormat.format(System.currentTimeMillis());
//        return currentTime;
//    }
}



