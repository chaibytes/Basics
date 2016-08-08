package com.chaibytes.androidapplicationjune11;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.os.ResultReceiver;
import android.widget.Toast;

/**
 * Created by pdebadarshini on 7/24/16.
 */
public class MyResultReceiver extends ResultReceiver {

    public MyResultReceiver (Handler handler) {
        super(handler);
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        super.onReceiveResult(resultCode, resultData);

    }
}
