package com.devs.android_cleanarch_mvp.presentation.navigation;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.devs.android_cleanarch_mvp.presentation.view.activity.MainActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Deven on 2019-09-24.
 */

@Singleton
public class Navigator {

    @Inject
    public Navigator(){}

    public void addFragment(Context context, int containerId, Fragment targetFragment) {
        final FragmentTransaction fragmentTransaction = ((MainActivity)context).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerId, targetFragment);
        fragmentTransaction.commit();
    }

    public void addFragmentWithBack(Context context, int containerId, Fragment targetFragment) {
        //targetFragment.setEnterTransition(new Slide(Gravity.BOTTOM));
        //targetFragment.setExitTransition(new Slide(Gravity.TOP));
        final FragmentTransaction fragmentTransaction = ((MainActivity)context).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerId, targetFragment, targetFragment.getClass().getSimpleName());
        fragmentTransaction.addToBackStack(targetFragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }

    public void replaceFragment(Context context, int containerId, Fragment targetFragment) {
        final FragmentTransaction fragmentTransaction = ((MainActivity)context).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerId, targetFragment);
        fragmentTransaction.commit();
    }
}


