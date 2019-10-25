package com.devs.android_cleanarch_mvp.presentation.navigation;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.devs.android_cleanarch_mvp.presentation.view.activity.HomeActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Deven on 2019-09-24.
 */

@Singleton
public class Navigator {

    private static final String TAG = Navigator.class.getSimpleName();

    @Inject
    public Navigator(){}

    public void addFragment(Context context, int containerId, Fragment targetFragment) {
        final FragmentTransaction fragmentTransaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerId, targetFragment);
        fragmentTransaction.commit();
    }

    public void addFragmentWithBack(Context context, int containerId, Fragment targetFragment) {
        //targetFragment.setEnterTransition(new Slide(Gravity.BOTTOM));
        //targetFragment.setExitTransition(new Slide(Gravity.TOP));
        final FragmentTransaction fragmentTransaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerId, targetFragment, targetFragment.getClass().getSimpleName());
        fragmentTransaction.addToBackStack(targetFragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }

    public void replaceFragment(Context context, int containerId, Fragment targetFragment) {
        final FragmentTransaction fragmentTransaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerId, targetFragment);
        fragmentTransaction.commit();
    }

    public void popFragment(Context context) {
        FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
            //  Toast.makeText(this,"pop",Toast.LENGTH_SHORT).show();
            Log.i(TAG,
                    "stack count: " + fragmentManager.getBackStackEntryCount());
        }
    }

    public void popAllFragments(Context context) {
        FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }

    public void startNewActivity(Context context, Class<?> destination) {
        context.startActivity(new Intent(context, destination));
    }

}


