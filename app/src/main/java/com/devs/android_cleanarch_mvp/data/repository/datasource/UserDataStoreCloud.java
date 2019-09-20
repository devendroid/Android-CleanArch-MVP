package com.devs.android_cleanarch_mvp.data.repository.datasource;

import com.devs.android_cleanarch_mvp.data.model.UserDto;
import com.devs.android_cleanarch_mvp.data.remote.RetroClient;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by Deven on 2019-09-07.
 */
/**
 * {@link UserDataStore} implementation based on connections to the api (Cloud).
 */
public class UserDataStoreCloud implements  UserDataStore {


    @Override
    public Observable<Response<List<UserDto>>> userDtoList() {
        return RetroClient.restApi().userDtoList();
    }

    @Override
    public Observable<Response<UserDto>> userDtoDetails(int userId) {
        return null;
    }
}
