package com.example.hasee.healthrecordsystem;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.hasee.healthrecordsystem.fragment.MyFragmentPagerAdapter;

/**
 * Created by hasee on 2018/2/26.
 */

public class MainPage extends AppCompatActivity implements ViewPager.OnPageChangeListener,RadioGroup.OnCheckedChangeListener{
    private ViewPager viewPager;
    private MyFragmentPagerAdapter mAdapter;
    private RadioGroup tab_bar;
    private RadioButton rb_report;
    private RadioButton rb_record;
    private RadioButton rb_fmanage;
    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE=2;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_radio);
        init();
    }

    private void init(){
        tab_bar=(RadioGroup)findViewById(R.id.tab_bar);
        rb_report=(RadioButton)findViewById(R.id.rb_report);
        rb_record=(RadioButton)findViewById(R.id.rb_record);
        rb_fmanage=(RadioButton)findViewById(R.id.rb_fmanage);
        rb_report.setChecked(true);
        tab_bar.setOnCheckedChangeListener(this);
        mAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager());
        viewPager=(ViewPager)findViewById(R.id.vpager);
        viewPager.setAdapter(mAdapter);
        viewPager.setCurrentItem(PAGE_ONE);
        viewPager.addOnPageChangeListener(this);
    }

    //RadioGroup监听选择事件
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_report:
                viewPager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_record:
                viewPager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_fmanage:
                viewPager.setCurrentItem(PAGE_THREE);
                break;
        }
    }

    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (viewPager.getCurrentItem()) {
                case PAGE_ONE:
                    rb_report.setChecked(true);
                    break;
                case PAGE_TWO:
                    rb_record.setChecked(true);
                    break;
                case PAGE_THREE:
                    rb_fmanage.setChecked(true);
                    break;
            }
        }
    }
}
