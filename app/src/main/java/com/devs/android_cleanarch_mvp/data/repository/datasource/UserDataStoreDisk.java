package com.devs.android_cleanarch_mvp.data.repository.datasource;

import com.devs.android_cleanarch_mvp.data.model.UserDto;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by Deven on 2019-09-07.
 */
public class UserDataStoreDisk implements UserDataStore {
    @Override
    public Observable<Response<List<UserDto>>> userDtoList() {
        return null;
    }

    @Override
    public Observable<Response<UserDto>> userDtoDetails(int userId) {
        return null;
    }
}
