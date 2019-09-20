package com.devs.android_cleanarch_mvp.data.repository.datasource;

/**
 * Created by Deven on 2019-09-07.
 */

import android.content.Context;

/**
 * Factory that creates different implementations of {@link UserDataStore}.
 */
public class UserDataStoreFactory {

    private final Context context;
    //private final UserCache userCache;


    public UserDataStoreFactory(Context context) {
        this.context = context;
    }

    /**
     * Create {@link UserDataStore} to retrieve data from the Cloud.
     */
    public UserDataStore createDataStoreCloud() {
       // return new CloudUserDataStore(restApi, this.userCache);
        return new UserDataStoreCloud();
    }


}
