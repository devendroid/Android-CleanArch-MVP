package com.devs.android_cleanarch_mvp.presentation.di;

import com.devs.android_cleanarch_mvp.presentation.view.activity.BaseActivity;
import com.devs.android_cleanarch_mvp.presentation.view.activity.HomeActivity;
import com.devs.android_cleanarch_mvp.presentation.view.activity.SplashActivity;
import com.devs.android_cleanarch_mvp.presentation.view.fragment.BaseFragment;
import com.devs.android_cleanarch_mvp.presentation.view.fragment.LoginFrag;
import com.devs.android_cleanarch_mvp.presentation.view.fragment.UserListFrag;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Deven on 2019-09-26.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

   void inject(BaseActivity activity);
   void inject(UserListFrag frag);
   void inject(LoginFrag frag);
   void inject(SplashActivity act);

}
