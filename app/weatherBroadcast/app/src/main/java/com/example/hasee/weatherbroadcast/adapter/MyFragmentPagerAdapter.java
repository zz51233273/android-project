package com.example.hasee.weatherbroadcast.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.hasee.weatherbroadcast.fragment.MyFragment1;
import com.example.hasee.weatherbroadcast.fragment.MyFragment2;
import com.example.hasee.weatherbroadcast.fragment.MyFragment3;
import com.example.hasee.weatherbroadcast.weather.FragmentPager;

/**
 * Created by hasee on 2018/2/6.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT = 3;
    private MyFragment1 myFragment1 = null;
    private MyFragment2 myFragment2 = null;
    private MyFragment3 myFragment3 = null;


    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new MyFragment1();
        myFragment2 = new MyFragment2();
        myFragment3 = new MyFragment3();
    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case FragmentPager.PAGE_ONE:
                fragment = myFragment1;
                break;
            case FragmentPager.PAGE_TWO:
                fragment = myFragment2;
                break;
            case FragmentPager.PAGE_THREE:
                fragment = myFragment3;
                break;
        }
        return fragment;
    }


}

