package com.example.hasee.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BroadcastActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button)super.findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String Intent_Action = "com";
                Intent intent = new Intent(Intent_Action);
                sendBroadcast(intent);
                Log.d("BroadcastReceiver","sendbroadcast");
            }
        });

    }
}