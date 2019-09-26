package com.devs.android_cleanarch_mvp.presentation.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.devs.android_cleanarch_mvp.MyApplication;
import com.devs.android_cleanarch_mvp.R;
import com.devs.android_cleanarch_mvp.presentation.navigation.Navigator;
import com.devs.android_cleanarch_mvp.presentation.view.fragment.UserListFrag;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity  {

    @Inject  Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication)getApplication()).getAppComponent().inject(this);

        navigator.replaceFragment(this,R.id.fragment_container, new UserListFrag());

    }

}
