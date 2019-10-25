package com.devs.android_cleanarch_mvp.data.repository.datasource;

/**
 * Created by Deven on 2019-09-07.
 */

import android.content.Context;

import com.devs.android_cleanarch_mvp.data.cache.AppSession;
import com.devs.android_cleanarch_mvp.data.model.mapper.UserMapper;

import javax.inject.Inject;

/**
 * Factory that creates different implementations of {@link UserDataStore}.
 */
public class UserDataStoreFactory {

    private final Context context;
    private UserMapper userMapper;
    private AppSession appSession;



    @Inject
    public UserDataStoreFactory(Context context, UserMapper userMapper, AppSession appSession) {
        this.context = context;
        this.userMapper = userMapper;
        this.appSession = appSession;
    }

    /**
     * Create {@link UserDataStore} to retrieve data from the Cloud.
     */
    public UserDataStore createDataStoreCloud() {
       // return new CloudUserDataStore(restApi, this.userCache);
        return new UserDataStoreCloud(userMapper);
    }

    /**
     * Create {@link UserDataStore} to retrieve data from the Disk/Cache.
     */
    public UserDataStore createDataStoreDisk() {
        // return new CloudUserDataStore(restApi, this.userCache);
        return new UserDataStoreDisk(userMapper, appSession);
    }


}
