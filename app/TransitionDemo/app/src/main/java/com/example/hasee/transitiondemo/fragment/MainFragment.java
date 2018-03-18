package com.example.hasee.transitiondemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hasee.transitiondemo.R;


public class MainFragment extends ListFragment {
    private OnListItemClickListener onListItemClickListener;

    public interface OnListItemClickListener{
        void onListItemClick(int position);
    }

    public MainFragment(){}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onListItemClickListener = (OnListItemClickListener) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String listData[] = getResources().getStringArray(R.array.list_name);
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, listData);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        onListItemClickListener.onListItemClick(position);
    }
}
