package com.example.hasee.sqlimagedemo;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileInputStream;

/**
 * Created by hasee on 2018/3/18.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }

    public Cursor onQueryPhoto(SQLiteDatabase db){
        Cursor cursor=null;
        String sql="Select * from photo";
        cursor=db.rawQuery(sql,null);
        return cursor;
    }
    @Override
    public void onCreate(SQLiteDatabase db){

    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}
