package com.devs.android_cleanarch_mvp.presentation.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.devs.android_cleanarch_mvp.MyApplication;
import com.devs.android_cleanarch_mvp.R;
import com.devs.android_cleanarch_mvp.presentation.navigation.Navigator;
import com.devs.android_cleanarch_mvp.presentation.view.fragment.LoginFrag;
import com.devs.android_cleanarch_mvp.presentation.view.fragment.UserListFrag;

import javax.inject.Inject;

/**
 * Created by Deven on 2019-10-07.
 */
public class LoginSignUpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        navigator.replaceFragment(this,R.id.fragment_container, new LoginFrag());

    }

}
