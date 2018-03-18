package com.example.hasee.transitiondemo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hasee.transitiondemo.fragment.AutoTransitionFragment;
import com.example.hasee.transitiondemo.fragment.ChangeBoundsFragment;
import com.example.hasee.transitiondemo.fragment.ChangeClipBoundsFragment;
import com.example.hasee.transitiondemo.fragment.ChangeImageTransformFragment;
import com.example.hasee.transitiondemo.fragment.ChangeScrollFragment;
import com.example.hasee.transitiondemo.fragment.ChangeTransformFragment;
import com.example.hasee.transitiondemo.fragment.CustomTransitionWithSceneFragment;
import com.example.hasee.transitiondemo.fragment.CustomTransitionWithoutSceneFragment;
import com.example.hasee.transitiondemo.fragment.ExplodeFadeSlideFragment;
import com.example.hasee.transitiondemo.fragment.MainFragment;
import com.example.hasee.transitiondemo.fragment.PathMotionFragment;
import com.example.hasee.transitiondemo.fragment.SceneFragment;
import com.example.hasee.transitiondemo.fragment.TransitionSetFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.OnListItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            MainFragment mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content, mainFragment)
                    .commit();
        }
    }

    @Override
    public void onListItemClick(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new AutoTransitionFragment();
                break;
            case 1:
                fragment = new ChangeBoundsFragment();
                break;
            case 2:
                fragment = new ChangeClipBoundsFragment();
                break;
            case 3:
                fragment = new ChangeImageTransformFragment();
                break;
            case 4:
                fragment = new ChangeScrollFragment();
                break;
            case 5:
                fragment = new ChangeTransformFragment();
                break;
            case 6:
                fragment = new ExplodeFadeSlideFragment();
                break;
            case 7:
                fragment = new TransitionSetFragment();
                break;
            case 8:
                fragment = new PathMotionFragment();
                break;
            case 9:
                fragment = new CustomTransitionWithoutSceneFragment();
                break;
            case 10:
                fragment = new SceneFragment();
                break;
            case 11:
                fragment = new CustomTransitionWithSceneFragment();
                break;
            default:
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragment)
                .addToBackStack(null)
                .commit();
    }
}
