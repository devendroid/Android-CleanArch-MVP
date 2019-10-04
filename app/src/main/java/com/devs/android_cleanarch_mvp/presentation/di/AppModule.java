package com.devs.android_cleanarch_mvp.presentation.di;

import android.content.Context;

import com.devs.android_cleanarch_mvp.MyApplication;
import com.devs.android_cleanarch_mvp.data.model.mapper.UserMapper;
import com.devs.android_cleanarch_mvp.data.repository.UserRepositoryImp;
import com.devs.android_cleanarch_mvp.domain.repository.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Deven on 2019-10-01.
 */

@Module
public class AppModule {

    Context myApplication;

    public AppModule(Context myApplication){
        this.myApplication = myApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.myApplication;
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(UserRepositoryImp userRepositoryImp) {
        return userRepositoryImp;
    }

//    @Provides
//    @Singleton
//    UserMapper provideUserMapper(UserMapper userMapper) {
//        return userMapper;
//    }

}
