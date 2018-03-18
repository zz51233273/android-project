package com.example.hasee.transitiondemo.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.transition.ChangeClipBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.hasee.transitiondemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ChangeClipBoundsFragment extends Fragment {
    @BindView(R.id.root)
    LinearLayout mRoot;
    @BindView(R.id.photo)
    ImageView mImageView;
    private Transition mTransition;
    private static final Rect BOUNDS = new Rect(0, 0, 0, 0);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_clip_bounds, container, false);
        ButterKnife.bind(this, view);
        mTransition = new ChangeClipBounds();
        return view;
    }

    @OnClick(R.id.toggle)
    void toggle(){
        TransitionManager.beginDelayedTransition(mRoot, mTransition);
        if (BOUNDS.equals(ViewCompat.getClipBounds(mImageView))) {
            ViewCompat.setClipBounds(mImageView, null);     //指定图片可视区域
        } else {
            ViewCompat.setClipBounds(mImageView, BOUNDS);
        }
    }
}
