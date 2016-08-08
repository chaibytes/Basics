package com.chaibytes.androidapplicationjune11;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ResponseReceiver extends BroadcastReceiver {

        public static final String ACTION_RESP = "com.chaibytes.androidapplicationjune11.someAction";

        public ResponseReceiver() {

        }

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("ResponseReceiver", "ResponseReceiver.onReceive()");
            // Handle Intent here

            Toast.makeText(context, "Hello World !!!!!", Toast.LENGTH_LONG).show();

            String name = intent.getExtras().getString("Person");
            Toast.makeText(context, name, Toast.LENGTH_LONG).show();

        }
}
