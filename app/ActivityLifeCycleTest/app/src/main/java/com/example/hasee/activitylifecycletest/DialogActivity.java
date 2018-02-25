package com.example.hasee.activitylifecycletest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DialogActivity extends Activity {
    //此处需要将AppcombatActivity改为Activity
    //AppcombatActivity好像不支持主题
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
    }
}
