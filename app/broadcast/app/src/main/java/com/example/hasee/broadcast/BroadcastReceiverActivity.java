package com.example.hasee.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


public class BroadcastReceiverActivity extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        String Intent_Action = intent.getAction();
        Toast.makeText(context, "收到广播~", Toast.LENGTH_SHORT).show();
        if("com".equals(Intent_Action)){
            Log.d("Receiver","onReceive");
        }
    }
}