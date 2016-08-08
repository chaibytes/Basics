package com.chaibytes.androidapplicationjune11;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.os.ResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ServiceActivity extends AppCompatActivity {

    private ResponseReceiver receiver;
    private IntentFilter filter;

    static TextView tv;

    public static Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Log.d("ServiceActivity", String.format("Handler.handleMessage(): msg=%s", msg));
            //super.handleMessage(msg);
            tv.setText("Message Recieved : " + Integer.toString(msg.what));
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        filter = new IntentFilter(ResponseReceiver.ACTION_RESP);
        receiver = new ResponseReceiver();
        registerReceiver(receiver, filter);

        tv = (TextView) findViewById(R.id.display_text_view);

        Button mybtn = (Button) findViewById(R.id.button_start_service);
        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntentService = new Intent(ServiceActivity.this, MyIntentService.class);
                myIntentService.putExtra("Person", "Daniel");
                // Uses ResultReceiver
                myIntentService.putExtra(ApplicationVariables.RESULT_RECEIVER, new ResultReceiver(mHandler) {
                    @Override
                    protected void onReceiveResult(int resultCode, Bundle resultData) {
                        Toast.makeText(getApplicationContext(), "onReceiveResult() method", Toast.LENGTH_LONG).show();
                        super.onReceiveResult(resultCode, resultData);
                    }
                });
                startService(myIntentService);
            }
        });


        Button taskBtn = (Button) findViewById(R.id.button_async_task);
        taskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyAsyncTask().execute("Lottie");
            }
        });


        Button handlerBtn = (Button) findViewById(R.id.button_handler);
        handlerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread myTh = new Thread(new MyRunnable());
                myTh.start();
            }
        });

        Button notifyBtn = (Button) findViewById(R.id.button_create_notification);
        notifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new Notification
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext())
                        .setContentText("My Notification")
                        .setSmallIcon(R.drawable.demo_notification_icon)
                        .setContentText("Hello World !");
                Intent resultIntent = new Intent(getApplicationContext(), ResultActivity.class);
                PendingIntent resultingPendingIntent = PendingIntent.getActivity(
                        getApplicationContext(),
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

                builder.setContentIntent(resultingPendingIntent);
                int notificationID = 001;
                NotificationManager notifyMgr =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notifyMgr.notify(notificationID, builder.build());
            }
        });

    }


    public void onStop() {
        if (receiver != null) {
            unregisterReceiver(receiver);
            receiver = null;
        }
        super.onStop();

        //Toast.makeText(this, "PostLoginScreenActivity.onStop() method", Toast.LENGTH_LONG).show();
    }

    private class MyAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String ... text) {
            String newString = text[0].concat(" Welcome");

            return newString;
        }

        @Override
        protected void onPostExecute(String result) {
            tv.setText(result);
        }
    }



}
