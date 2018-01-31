package com.example.hasee.weatherbroadcast.database;


import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.example.hasee.weatherbroadcast.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hasee on 2018/1/31.
 */

public class WriteSql extends Activity {
    private String f;   //数据库存入手机的路径
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_info);
        //将raw目录下的db文件，存入<包名>/databases/目录下
        writeDB();
        Log.d("test", "DB uri : "+ getDatabasePath("city.db"));
        finish();
    }

    public void writeDB(){
        f = getFilesDir()+"\\databases\\"+"city.db";  //此处如果是放在应用包名的目录下,自动放入“databases目录下
        FileOutputStream fout = null;
        InputStream inputStream = null;
        try {
            inputStream = getResources().openRawResource(R.raw.city);
            fout = new FileOutputStream(new File(f));
            byte[] buffer = new byte[128];
            int len = 0;
            while ((len = inputStream.read(buffer))!=-1){
                fout.write(buffer, 0, len);
            }
            buffer = null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
