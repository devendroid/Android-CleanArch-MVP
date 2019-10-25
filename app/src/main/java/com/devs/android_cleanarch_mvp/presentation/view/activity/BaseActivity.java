package com.devs.android_cleanarch_mvp.presentation.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.devs.android_cleanarch_mvp.MyApplication;
import com.devs.android_cleanarch_mvp.presentation.navigation.Navigator;

import javax.inject.Inject;

/**
 * Created by Deven on 2019-10-07.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    protected Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MyApplication)getApplication()).getAppComponent().inject(this);
    }
}
