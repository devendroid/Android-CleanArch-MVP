package com.devs.android_cleanarch_mvp;

import android.app.Application;

import com.devs.android_cleanarch_mvp.presentation.di.AppComponent;
import com.devs.android_cleanarch_mvp.presentation.di.AppModule;
import com.devs.android_cleanarch_mvp.presentation.di.DaggerAppComponent;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Deven on 2019-09-07.
 */
public class MyApplication extends Application {


    public static final boolean ENABLE_API_DEBUGGER = true;

     private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
