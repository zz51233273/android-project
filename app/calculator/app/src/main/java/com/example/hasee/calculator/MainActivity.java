package com.example.hasee.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

// Edit by Hbu_David 2017.6.15
// Upgrade to Android Studio 3.0.1 ,Gradle 4.1 ,David 2017.11.24

public class MainActivity extends AppCompatActivity {
    //变量定义
    private EditText editText;          //输入框：用于输入数字
    private String operator;            //操作符：记录 + - * / 符号
    private double n1, n2, Result;     //操作数：操作符两端的数字，n1为左操作数，n2为右操作数。
    private TextView textView;          //文本框：显示计算过程和计算结果
    private Button buttn[]=new Button[11];
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;   //按钮：十个数字
    private Button btnPlus, btnMinus, btnMultiply, btnDivide;              //按钮：加减乘除
    private Button btnPoint, btnEqual, btnClear;                          //按钮：小数点，等号，清空

    private View.OnClickListener lisenter = new View.OnClickListener() {//侦听器
        @Override
        public void onClick(View view) {//点击事件
            editText = (EditText) findViewById(R.id.editviewdavid);//与XML中定义好的EditText控件绑定
            textView = (TextView) findViewById(R.id.textviewdavid);//与XML中定义好的TextView控件绑定
            editText.setCursorVisible(false);//隐藏输入框光标
            String str;
            Button button = (Button) view;   //把点击获得的id信息传递给button
            DecimalFormat MyFormat = new DecimalFormat("###.##");//控制Double转为String的格式

            try {
                for(int i=1;i<10;i++){
                    if((Button)findViewById(button.getId())==buttn[i]){
                        editText.setText(editText.getText().toString() + i);
                    }
                }
                switch (button.getId())//获取点击按钮的ID，通过ID选择对应的选项执行
                {
                    case R.id.button0://0
                    {
                        str = editText.getText().toString();
                        //此处可以考虑添加代码，限制用户输入00,000等 2017.6.15
                        editText.setText(str + 0);
                        break;
                    }
                    case R.id.buttonClear://Clear
                    {
                        editText.setText("");
                        textView.setText("");
                        Result = 0;
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
                        editText.setText("");
                        textView.setText(MyFormat.format(n1) + operator);
                        break;
                    }
                    case R.id.buttonMinus://操作符-
                    {
                        str = editText.getText().toString();
                        n1 = Double.parseDouble(str);
                        operator = "-";
                        editText.setText("");
                        textView.setText(MyFormat.format(n1) + operator);
                        break;
                    }
                    case R.id.buttonMultiply://操作符*
                    {
                        str = editText.getText().toString();
                        n1 = Double.parseDouble(str);
                        operator = "*";
                        editText.setText("");
                        textView.setText(MyFormat.format(n1) + operator);
                        break;
                    }

                    case R.id.buttonDivide://操作符 /
                    {
                        str = editText.getText().toString();
                        n1 = Double.parseDouble(str);
                        operator = "/";
                        editText.setText("");
                        textView.setText(MyFormat.format(n1) + operator);
                        break;
                    }
                    case R.id.buttonEqual://操作符=
                    {
                        if (operator == "+") {
                            str = editText.getText().toString();
                            n2 = Double.parseDouble(str);
                            Result = n1 + n2;
                            textView.setText(MyFormat.format(n1) + operator + MyFormat.format(n2) + "=" + MyFormat.format(Result));
                            editText.setText(MyFormat.format(Result) + "");
                        } else if (operator == "-") {
                            str = editText.getText().toString();
                            n2 = Double.parseDouble(str);
                            Result = n1 - n2;
                            textView.setText(MyFormat.format(n1) + operator + MyFormat.format(n2) + "=" + MyFormat.format(Result));
                            editText.setText(MyFormat.format(Result) + "");
                        } else if (operator == "*") {
                            str = editText.getText().toString();
                            n2 = Double.parseDouble(str);
                            Result = n1 * n2;
                            textView.setText(MyFormat.format(n1) + operator + MyFormat.format(n2) + "=" + MyFormat.format(Result));
                            editText.setText(MyFormat.format(Result) + "");
                        } else if (operator == "/") {
                            str = editText.getText().toString();
                            n2 = Double.parseDouble(str);
                            if (n2 == 0) {
                                editText.setText("");
                                textView.setText("除数不能为0");
                                break;
                            } else {
                                Result = n1 / n2;
                                textView.setText(MyFormat.format(n1) + operator + MyFormat.format(n2) + "=" + MyFormat.format(Result));
                                editText.setText(MyFormat.format(Result) + "");
                            }
                        }
                        break;
                    }
                }
            } catch (Exception e) {
            }
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
        //为按钮添加监听器
        for(int i=0;i<10;i++){
            buttn[i].setOnClickListener(lisenter);
        }
        btnPlus.setOnClickListener(lisenter);
        btnMinus.setOnClickListener(lisenter);
        btnMultiply.setOnClickListener(lisenter);
        btnDivide.setOnClickListener(lisenter);
        btnPoint.setOnClickListener(lisenter);
        btnEqual.setOnClickListener(lisenter);
        btnClear.setOnClickListener(lisenter);
    }
}
