package com.devs.android_cleanarch_mvp.presentation.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseLongArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.devs.android_cleanarch_mvp.MyApplication;
import com.devs.android_cleanarch_mvp.R;
import com.devs.android_cleanarch_mvp.data.cache.AppSession;
import com.devs.android_cleanarch_mvp.data.model.mapper.UserMapper;
import com.devs.android_cleanarch_mvp.data.repository.UserRepositoryImp;
import com.devs.android_cleanarch_mvp.data.repository.datasource.UserDataStoreFactory;
import com.devs.android_cleanarch_mvp.domain.interactor.GetLoggedUser;
import com.devs.android_cleanarch_mvp.domain.repository.UserRepository;
import com.devs.android_cleanarch_mvp.presentation.model.UserModel;
import com.devs.android_cleanarch_mvp.presentation.model.mapper.UserModelMapper;
import com.devs.android_cleanarch_mvp.presentation.presenter.SplashPresenter;
import com.devs.android_cleanarch_mvp.presentation.utils.Utilities;
import com.devs.android_cleanarch_mvp.presentation.view.fragment.UserListFrag;
import com.devs.android_cleanarch_mvp.presentation.viewer.SplashViewer;
import com.google.android.material.navigation.NavigationView;

import javax.inject.Inject;

/**
 * Created by Deven on 2019-10-01.
 */
public class SplashActivity extends BaseActivity implements SplashViewer {


    private final static int SPLASH_DELAY = 3; //seconds
    private NavigationView navigationView;

    @Inject
    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ((MyApplication)getApplication()).getAppComponent().inject(this);

        // these objects are injected
//        UserDataStoreFactory userDataStoreFactory = new UserDataStoreFactory(context(), new UserMapper(), new AppSession() );
//        UserRepository userRepository = new UserRepositoryImp(userDataStoreFactory, new AppSession() );
//        GetLoggedUser getLoggedUser = new GetLoggedUser(userRepository);
//        splashPresenter = new SplashPresenter(getLoggedUser, new UserModelMapper());

        splashPresenter.setViewer(this);

        splashPresenter.checkLoggedUser();

    }


    @Override
    public void showLoginScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigator.startNewActivity(SplashActivity.this, LoginSignUpActivity.class);
                finish();
            }
        }, SPLASH_DELAY*1000);
    }

    @Override
    public void showHomeScreen(UserModel userModel) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigator.startNewActivity(SplashActivity.this, HomeActivity.class);
                finish();
            }
        }, SPLASH_DELAY*1000);
    }

    //=================

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context context() {
        return null;
    }
}
