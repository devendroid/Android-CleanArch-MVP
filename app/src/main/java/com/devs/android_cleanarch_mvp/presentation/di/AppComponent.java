package com.devs.android_cleanarch_mvp.presentation.di;

import com.devs.android_cleanarch_mvp.presentation.view.activity.MainActivity;
import com.devs.android_cleanarch_mvp.presentation.view.fragment.UserListFrag;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Deven on 2019-09-26.
 */

@Singleton
@Component
public interface AppComponent {

   void inject(MainActivity activity);
   void inject(UserListFrag frag);

}
