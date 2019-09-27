package com.devs.android_cleanarch_mvp.data.repository.datasource;

/**
 * Created by Deven on 2019-09-07.
 */

import android.content.Context;

import com.devs.android_cleanarch_mvp.data.cache.AppSession;
import com.devs.android_cleanarch_mvp.data.model.mapper.UserMapper;

/**
 * Factory that creates different implementations of {@link UserDataStore}.
 */
public class UserDataStoreFactory {

    private final Context context;
    private UserMapper userMapper;



    public UserDataStoreFactory(Context context, UserMapper userMapper) {
        this.context = context;
        this.userMapper = userMapper;
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
        return new UserDataStoreDisk(userMapper);
    }


}
