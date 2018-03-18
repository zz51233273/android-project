package com.example.hasee.healthrecordsystem.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hasee.healthrecordsystem.R;

/**
 * Created by hasee on 2018/2/26.
 */

public class Fragment2 extends Fragment{
    public Fragment2(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.medical_records,container,false);
        return view;
    }
}
