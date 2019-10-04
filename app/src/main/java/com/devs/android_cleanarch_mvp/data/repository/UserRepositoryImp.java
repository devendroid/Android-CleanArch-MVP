package com.devs.android_cleanarch_mvp.data.repository;

/**
 * Created by Deven on 2019-09-07.
 */

import com.devs.android_cleanarch_mvp.data.cache.AppSession;
import com.devs.android_cleanarch_mvp.data.model.UserDto;
import com.devs.android_cleanarch_mvp.data.model.mapper.UserMapper;
import com.devs.android_cleanarch_mvp.data.repository.datasource.UserDataStore;
import com.devs.android_cleanarch_mvp.data.repository.datasource.UserDataStoreFactory;
import com.devs.android_cleanarch_mvp.domain.model.ApiResponse;
import com.devs.android_cleanarch_mvp.domain.model.User;
import com.devs.android_cleanarch_mvp.domain.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import retrofit2.Response;

/**
 * {@link UserRepository} for retrieving user data.
 */
@Singleton
public class UserRepositoryImp implements UserRepository {

    private final UserDataStoreFactory userDataStoreFactory;
    private AppSession appSession;

    @Inject
    public UserRepositoryImp(UserDataStoreFactory userDataStoreFactory, AppSession appSession) {
        this.userDataStoreFactory = userDataStoreFactory;
        this.appSession = appSession;
    }

    @Override
    public Observable<ApiResponse<List<User>>> users() {
        //we always get all users from the cloud
         UserDataStore userDataStore = this.userDataStoreFactory.createDataStoreCloud();

        return userDataStore.userDtoList();
    }

    @Override
    public Observable<ApiResponse<User>> user(int userId) {
        UserDataStore userDataStore = null;
        if(appSession.getCatchedUser(userId) == null) {
            userDataStore = this.userDataStoreFactory.createDataStoreCloud();
        }
        else {
            userDataStore = this.userDataStoreFactory.createDataStoreDisk();
        }
        return userDataStore.userDtoDetails(userId);
    }

    @Override
    public Observable<ApiResponse<User>> loggedUser() {
        UserDataStore userDataStore = this.userDataStoreFactory.createDataStoreDisk();
        return userDataStore.userDtoLogin();
    }

}
