package com.example.admin.firstproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {
    public Receiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String received_text = intent.getStringExtra("send_text");
        Toast toast = Toast.makeText(context, "You inputed value as : " + received_text, Toast.LENGTH_LONG);
        toast.show();
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
