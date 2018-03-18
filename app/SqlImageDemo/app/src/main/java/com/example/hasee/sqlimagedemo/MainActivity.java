package com.example.hasee.sqlimagedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button insertBut,lookBut;
    ImageView showImg;
    private CustomSQLiteOpenHelper customSQLiteOpenHelper;
    private SQLiteDatabase database;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insertBut=(Button)findViewById(R.id.insert_button);
        insertBut.setOnClickListener(this);
        lookBut=(Button)findViewById(R.id.look_button);
        lookBut.setOnClickListener(this);
        showImg=(ImageView)findViewById(R.id.show_img);
        dbHelper=new DBHelper(MainActivity.this,"hand_writing.db",null,3);  //创建帮助器对象
        customSQLiteOpenHelper = new CustomSQLiteOpenHelper(this);      //创建SQLIteOpenHelper对象（1）
        customSQLiteOpenHelper.getWritableDatabase();                           //通过getWritableDatabase()方式来新建SQLite数据库（2）
    }

    public void onClick(View v){
        int id = v.getId();
        switch (id){
            case R.id.insert_button:
                saveImage();
                break;
            case R.id.look_button:
                byte[] imgData=readImage();
                if(imgData!=null){
                    //将字节数组转化为位图
                    Bitmap imagebitmap= BitmapFactory.decodeByteArray(imgData,0,imgData.length);
                    showImg.setImageBitmap(imagebitmap);
                }else{
                    showImg.setBackgroundResource(android.R.drawable.menuitem_background);
                }
                break;
        }
    }

    public void saveImage(){        //保存图片于数据库
        database=dbHelper.getWritableDatabase();
        byte[] bytes=img(R.drawable.tian);
        ContentValues values=new ContentValues();
        values.put("name","天");
        values.put("photo",bytes);
        database.insert("photo",null,values);
        database.close();
    }

    public byte[] readImage(){      //读取图片
        database=dbHelper.getWritableDatabase();
        Cursor cur=dbHelper.onQueryPhoto(database);
        byte[] imgData=null;
        if(cur.moveToNext()){
            imgData=cur.getBlob(cur.getColumnIndex("photo"));
        }
        return imgData;
    }

    public byte[] img(int id){
        Bitmap bitmap=((BitmapDrawable)getResources().getDrawable(id)).getBitmap();//将图片转化为位图
        int size = bitmap.getWidth() * bitmap.getHeight() * 4;  //创建一个字节数组输出流,流的大小为size
        ByteArrayOutputStream baos = new ByteArrayOutputStream(size); //设置位图的压缩格式，质量为100%，并放入字节数组输出流中
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,baos);
        return baos.toByteArray();
    }

    class CustomSQLiteOpenHelper extends SQLiteOpenHelper {     //用于新建数据库
        private static final String DATABASE_NAME = "hand_writing.db";//数据库名字
        private static final int DATABASE_VERSION = 1;//数据库版本号
        private static final String CREATE_TABLE = "create table photo("
                + "id integer primary key autoincrement not null,"
                + "name varchar(10), "
                + "photo blob "
                + ");";//数据库里的表

        public CustomSQLiteOpenHelper(Context context) {
            this(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        private CustomSQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
            super(context, name, factory, version);//调用到SQLiteOpenHelper中
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
