package com.example.hasee.transitiondemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.hasee.transitiondemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ExplodeFadeSlideFragment extends Fragment {

    @BindView(R.id.root)
    FrameLayout mRoot;
    @BindView(R.id.view_1)
    View view1;
    @BindView(R.id.view_2)
    View view2;
    @BindView(R.id.view_3)
    View view3;
    @BindView(R.id.view_4)
    View view4;
    private ArrayList<View> mViews = new ArrayList<>();
    private Transition mTransition;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explode, container, false);
        ButterKnife.bind(this, view);
        if (mViews.isEmpty()){
            mViews.add(view1);
            mViews.add(view2);
            mViews.add(view3);
            mViews.add(view4);
        }
       // mTransition = new Explode();
        //mTransition = new Fade();
        mTransition = new Slide();
        return view;
    }

    @OnClick(R.id.toggle)
    void toggle(){
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        int vis = mViews.get(0).getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE;
        for (View view : mViews) {
            view.setVisibility(vis);
        }
    }
}
