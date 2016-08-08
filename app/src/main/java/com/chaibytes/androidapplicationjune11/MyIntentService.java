package com.chaibytes.androidapplicationjune11;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import android.widget.Toast;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class MyIntentService extends IntentService {

    ResultReceiver receiver;

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("MyIntentService", "MyIntentService.onHandleIntent()");
        // Gets data from incoming intent


        String dataString = intent.getStringExtra("Person");
        final String resultString = dataString.concat(" Smith");

        receiver = intent.getParcelableExtra(ApplicationVariables.RESULT_RECEIVER);

        //Post a toast onto the main thread
        Handler mHandler = new Handler(getMainLooper());
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), resultString, Toast.LENGTH_LONG).show();
            }
        });

        // Do some work here based on the String or any other task

//        Intent localIntent = new Intent(this, ResponseReceiver.class);
//        localIntent.putExtra("Person", resultString);
//        localIntent.setAction(ResponseReceiver.ACTION_RESP);
//        this.sendBroadcast(localIntent);

        Bundle b = new Bundle();
        receiver.send(0, b);
    }

}
