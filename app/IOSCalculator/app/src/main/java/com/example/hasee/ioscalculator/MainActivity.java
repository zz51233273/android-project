package com.example.hasee.ioscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.Random;

// Edit by Hbu_David 2017.6.15
// Upgrade to Android Studio 3.0.1 ,Gradle 4.1 ,David 2017.11.24

public class MainActivity extends AppCompatActivity {
    //变量定义
    private EditText editText;          //输入框：用于输入数字
    private String operator;            //操作符：记录 + - * / 符号
    private double n1, n2, Result;     //操作数：操作符两端的数字，n1为左操作数，n2为右操作数。
    //private double front;              //用于保存运算符左边的数值
    private Button buttn[]=new Button[11];
    private Button btnPlus, btnMinus, btnMultiply, btnDivide,btnPercent;            //按钮：加减乘除
    private Button btnPoint, btnEqual, btnClear,btnPlusMinus;                        //按钮：小数点，等号，清空，正负号
    private Button btnSquare,btnSquareRoot;                                        //按钮：平方，开方
    private String[] calculates={"+","-","*","/","^","√"};
    private boolean start=false,finish=false;                                       //用户开始运算 ； 一次运算完成
    private View.OnClickListener lisenter = new View.OnClickListener() {//侦听器
        @Override
        public void onClick(View view) {//点击事件
            editText = (EditText) findViewById(R.id.editviewdavid);//与XML中定义好的EditText控件绑定
            editText.setCursorVisible(false);//隐藏输入框光标
            String str;
            Button button = (Button) view;   //把点击获得的id信息传递给button
            DecimalFormat MyFormat = new DecimalFormat("###.####");//控制Double转为String的格式
            try {
                for(int i=1;i<10;i++){
                    if((Button)findViewById(button.getId())==buttn[i]){
                        if(operator!="")editText.setText("");
                        editText.setText(editText.getText().toString() + i);
                        start = true;
                        finish=false;
                    }
                }
                switch (button.getId())//获取点击按钮的ID，通过ID选择对应的选项执行
                {
                    case R.id.button0://0
                    {
                        if(operator!="")str="";
                        else str = editText.getText().toString();
                        //此处可以考虑添加代码，限制用户输入00,000等 2017.6.15
                        if(start==true) editText.setText(str + 0);
                        else editText.setText("0");
                        finish=false;
                        break;
                    }
                    case R.id.buttonClear://Clear
                    {
                        editText.setText("");
                        n1=n2=0;
                        operator="";
                        start=false;
                        finish=false;
                        break;
                    }
                    case R.id.buttonPoint://.
                    {
                        str = editText.getText().toString();
                        if (str.indexOf(".") != -1) //判断字符串中是否已包含小数点，如果有，就什么也不做
                        {
                        } else //如果没有小数点
                        {
                            if (str.equals("0"))//如果开始为0
                                editText.setText(("0" + ".").toString());
                            else if (str.equals(""))//如果初时显示为空，就什么也不做
                            {
                            } else
                                editText.setText(str + ".");
                        }
                        break;
                    }
                    case R.id.buttonPlus://操作符+
                    {
                        str = editText.getText().toString();
                        n1 = Double.parseDouble(str);
                        operator = "+";
                        break;
                    }
                    case R.id.buttonMinus://操作符-
                    {
                        str = editText.getText().toString();
                        n1 = Double.parseDouble(str);
                        operator = "-";
                        break;
                    }
                    case R.id.buttonMultiply://操作符*
                    {
                        str = editText.getText().toString();
                        n1 = Double.parseDouble(str);
                        operator = "*";
                        break;
                    }

                    case R.id.buttonDivide://操作符 /
                    {
                        str = editText.getText().toString();
                        n1 = Double.parseDouble(str);
                        operator = "/";
                        break;
                    }
                    case R.id.buttonPercent://操作符百分号
                    {
                        if(operator!=""){
                            double per=Double.parseDouble(editText.getText().toString());
                            editText.setText(per/100+"");
                        }else{
                            n1=n1/100;
                            editText.setText(MyFormat.format(n1)+"");
                        }
                        break;
                    }
                    case R.id.PlusMinus://操作符+/-
                    {
                        str=editText.getText().toString();
                        n1 = Double.parseDouble(str);
                        n1=-n1;
                        editText.setText(MyFormat.format(n1)+"");
                        break;
                    }
                    /*
                    case R.id.buttonSquare:
                    {
                        str=editText.getText().toString();
                        n1=Double.parseDouble(str);
                        operator="^";
                        editText.setText("");
                        textView.setText(MyFormat.format(n1)+operator);
                        break;
                    }
                    case R.id.buttonSquareRoot:
                    {
                        str=editText.getText().toString();
                        operator="√";
                        n1=Double.parseDouble(str);
                        if(n1<0)textView.setText("开方数不能小于0！");
                        else{
                            Result=Math.sqrt(n1);
                            textView.setText(operator+MyFormat.format(n1)+"="+MyFormat.format(Result));
                            editText.setText(MyFormat.format(Result)+"");
                        }
                        break;
                    }
                    */
                    case R.id.buttonEqual://操作符=
                    {
                        if (operator == "+") {
                            str = editText.getText().toString();
                            if(str==""){
                                Result=n1+n1;
                                editText.setText(MyFormat.format(Result) + "");
                            }else{
                                if(!finish) n2 = Double.parseDouble(str);
                                Result = n1 + n2;
                                editText.setText(MyFormat.format(Result) + "");
                            }
                            n1=Result;
                            finish=true;
                        } else if (operator == "-") {
                            str = editText.getText().toString();
                            if(str==""){
                                editText.setText("0");
                            }else{
                                if(!finish) n2 = Double.parseDouble(str);
                                Result = n1 - n2;
                                editText.setText(MyFormat.format(Result) + "");
                            }
                            n1=Result;
                            finish=true;
                        } else if (operator == "*") {
                            str = editText.getText().toString();
                            if(str==""){
                                Result=n1*n1;
                                editText.setText(MyFormat.format(Result) + "");
                            }else{
                                if(!finish) n2 = Double.parseDouble(str);
                                Result = n1 * n2;
                                editText.setText(MyFormat.format(Result) + "");
                            }
                            n1=Result;
                            finish=true;
                        } else if (operator == "/") {
                            str = editText.getText().toString();
                            if(str==""){
                                if (n1 == 0) {
                                    editText.setText("除数不能为0");
                                    break;
                                } else{
                                    editText.setText("1");
                                }
                            }else{
                                if(!finish) n2 = Double.parseDouble(str);
                                if (n2 == 0) {
                                    editText.setText("除数不能为0");
                                    break;
                                } else {
                                    Result = n1 / n2;
                                    editText.setText(MyFormat.format(Result) + "");
                                }
                            }
                            n1=Result;
                            finish=true;
                        }else finish=false;
                        break;
                    }
                }
            } catch (Exception e) {
            }
            if(start == true)btnClear.setText("AC");
            else btnClear.setText("C");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取按钮的id
        buttn[1] = (Button) findViewById(R.id.button1);
        buttn[2] = (Button) findViewById(R.id.button2);
        buttn[3] = (Button) findViewById(R.id.button3);
        buttn[4] = (Button) findViewById(R.id.button4);
        buttn[5] = (Button) findViewById(R.id.button5);
        buttn[6] = (Button) findViewById(R.id.button6);
        buttn[7] = (Button) findViewById(R.id.button7);
        buttn[8] = (Button) findViewById(R.id.button8);
        buttn[9] = (Button) findViewById(R.id.button9);
        buttn[0] = (Button) findViewById(R.id.button0);
        btnPlus = (Button) findViewById(R.id.buttonPlus);
        btnMinus = (Button) findViewById(R.id.buttonMinus);
        btnMultiply = (Button) findViewById(R.id.buttonMultiply);
        btnDivide = (Button) findViewById(R.id.buttonDivide);
        btnPoint = (Button) findViewById(R.id.buttonPoint);
        btnEqual = (Button) findViewById(R.id.buttonEqual);
        btnClear = (Button) findViewById(R.id.buttonClear);
        btnPlusMinus=(Button)findViewById(R.id.PlusMinus);
        btnPercent=(Button)findViewById(R.id.buttonPercent);
        /*btnSquare=(Button)findViewById(R.id.buttonSquare);
        btnSquareRoot=(Button)findViewById(R.id.buttonSquareRoot);*/
        //为按钮添加监听器
        for(int i=0;i<10;i++){
            buttn[i].setOnClickListener(lisenter);
        }
        /*btnSquareRoot.setOnClickListener(lisenter);
        btnSquare.setOnClickListener(lisenter);*/
        btnPercent.setOnClickListener(lisenter);
        btnPlusMinus.setOnClickListener(lisenter);
        btnPlus.setOnClickListener(lisenter);
        btnMinus.setOnClickListener(lisenter);
        btnMultiply.setOnClickListener(lisenter);
        btnDivide.setOnClickListener(lisenter);
        btnPoint.setOnClickListener(lisenter);
        btnEqual.setOnClickListener(lisenter);
        btnClear.setOnClickListener(lisenter);
    }
}
