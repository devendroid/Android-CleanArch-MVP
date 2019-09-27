package com.devs.android_cleanarch_mvp.data.repository.datasource;

import com.devs.android_cleanarch_mvp.data.model.UserDto;
import com.devs.android_cleanarch_mvp.data.model.mapper.UserMapper;
import com.devs.android_cleanarch_mvp.domain.model.ApiResponse;
import com.devs.android_cleanarch_mvp.domain.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by Deven on 2019-09-07.
 */
public class UserDataStoreDisk implements UserDataStore {

    public UserDataStoreDisk(UserMapper userMapper) {

    }

    @Override
    public Observable<ApiResponse<List<User>>> userDtoList() {



        return null;
    }

    @Override
    public Observable<ApiResponse<User>> userDtoDetails(int userId) {

        return null;
    }

    @Override
    public Observable<ApiResponse<User>> userDtoLogin() {

        return null;
    }
}
