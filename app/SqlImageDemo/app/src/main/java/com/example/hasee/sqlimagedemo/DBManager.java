package com.example.hasee.sqlimagedemo;

import android.content.Context;
import android.os.Environment;
import android.renderscript.ScriptGroup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by hasee on 2018/3/18.
 */

public class DBManager {
    public static final String DB_NAME="hand_writing.db";   //数据库名字
    public static final String PACKAGE_NAME="com.example.hasee.SqlImageDemo";   //包名
    public static final String DB_PATH="/data"+ Environment.getDataDirectory().getAbsolutePath()+"/"+PACKAGE_NAME;  //数据库的绝对路径
    private Context context;
    public DBManager(Context context){this.context=context;}

    public void writeData(){this.writeData(DB_PATH+"/databases");}

    public void writeData(String filePath){
        try{
            File file=new File(filePath);
            if(!file.exists()){     //判断文件是否存在
                file.mkdir();
                File file2=new File(filePath+"/"+DB_NAME);
                if(!file2.exists()){
                    InputStream is=context.getResources().openRawResource(R.raw.hand_writing);
                    FileOutputStream fos=new FileOutputStream(file2);
                    byte[] buffer=new byte[1024];
                    int readCount;
                    while((readCount=is.read(buffer))>0){
                        fos.write(buffer,0,readCount);
                    }
                    fos.close();
                    is.close();
                }
            }
        }catch (Exception e){

        }
    }
}
