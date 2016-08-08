package com.chaibytes.androidapplicationjune11;

import android.os.Message;

/**
 * Created by pdebadarshini on 6/12/16.
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
            Message msg = Message.obtain();
            msg.what = 999;
            ServiceActivity.mHandler.sendMessage(msg);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // Thread.currentThread().interrupt();
                e.printStackTrace();
            }
    }

}
