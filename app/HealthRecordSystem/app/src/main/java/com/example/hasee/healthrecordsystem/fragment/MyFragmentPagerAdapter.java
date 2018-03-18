package com.example.hasee.healthrecordsystem.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.hasee.healthrecordsystem.MainActivity;
import com.example.hasee.healthrecordsystem.MainPage;

/**
 * Created by hasee on 2018/2/26.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
    private final static int PAGER_COUNT=3;
    private Fragment1 fragment1 = null;
    private Fragment2 fragment2 = null;
    private Fragment3 fragment3 = null;
    public MyFragmentPagerAdapter(FragmentManager fm){
        super(fm);
        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();
    }

    public Fragment getItem(int position){
        Fragment fragment=null;
        switch (position) {
            case MainPage.PAGE_ONE:
                fragment = fragment1;
                break;
            case MainPage.PAGE_TWO:
                fragment = fragment2;
                break;
            case MainPage.PAGE_THREE:
                fragment = fragment3;
                break;
        }
        return fragment;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    public int getCount(){
        return PAGER_COUNT;
    }
}
