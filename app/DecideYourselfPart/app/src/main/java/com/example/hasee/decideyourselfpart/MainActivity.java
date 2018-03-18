package com.example.hasee.decideyourselfpart;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar  actionBar=getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.hide();
        }
    }
}
