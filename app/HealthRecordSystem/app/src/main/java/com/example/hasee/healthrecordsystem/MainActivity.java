package com.example.hasee.healthrecordsystem;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int CHANGE_EYE=1;
    private ImageView pwdEye;               //睁眼闭眼图片
    private ImageView numberClear;          //叉号图片
    private EditText phoneNumber;         //手机号
    private EditText password;             //密码
    private Button login;                   //登录
    private boolean isEyeOpened=false;      //密码是否显示
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {
            switch (msg.what){
                case CHANGE_EYE:
                    changeEyeImg();
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    void init(){
        pwdEye=(ImageView)findViewById(R.id.pwd_eye);
        pwdEye.setOnClickListener(this);
        numberClear=(ImageView)findViewById(R.id.phone_number_clear);
        numberClear.setOnClickListener(this);
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(this);
        phoneNumber=(EditText)findViewById(R.id.phone_number);
        password=(EditText)findViewById(R.id.password);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.pwd_eye:           //点击眼睛事件
                Message msg=new Message();
                msg.what=CHANGE_EYE;
                handler.sendMessage(msg);   //交给handler去处理改变眼睛图片的方法
                break;
            case R.id.phone_number_clear:   //清空输入的手机号事件
                phoneNumber.setText("");
                break;
            case R.id.login:            //登录事件
                login();
                break;
        }
    }

    private void changeEyeImg(){        //改变眼睛图片
        if(!isEyeOpened){
            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            pwdEye.setImageResource(R.drawable.open_eye);
            isEyeOpened=true;
        }else{
            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            pwdEye.setImageResource(R.drawable.close_eye);
            isEyeOpened=false;
        }
    }

    private void login(){
        Intent i = new Intent(MainActivity.this,MainPage.class);
        startActivity(i);
    }
}
