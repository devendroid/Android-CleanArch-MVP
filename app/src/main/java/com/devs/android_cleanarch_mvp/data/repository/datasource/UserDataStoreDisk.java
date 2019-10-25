package com.devs.android_cleanarch_mvp.data.repository.datasource;

import com.devs.android_cleanarch_mvp.AppConstants;
import com.devs.android_cleanarch_mvp.data.cache.AppSession;
import com.devs.android_cleanarch_mvp.data.model.UserDto;
import com.devs.android_cleanarch_mvp.data.model.mapper.UserMapper;
import com.devs.android_cleanarch_mvp.data.remote.RetroClient;
import com.devs.android_cleanarch_mvp.domain.model.ApiResponse;
import com.devs.android_cleanarch_mvp.domain.model.User;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import retrofit2.Response;

/**
 * Created by Deven on 2019-09-07.
 */
public class UserDataStoreDisk implements UserDataStore {

    private UserMapper userMapper;
    private AppSession appSession;

    public UserDataStoreDisk(UserMapper userMapper, AppSession appSession) {
        this.userMapper = userMapper;
        this.appSession = appSession;
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
    public Observable<ApiResponse<User>> userLogin(String username, String password) {
        // Login from Local/AppSession + Perform Mapping
        // Performing transformation from Response<UserDto> to ApiResponse<User> inside Observable
        Observable<Response<UserDto>> observable = RetroClient.restApi().userLogin();

        return observable.map(new Function<Response<UserDto>, ApiResponse<User>>() {
            @Override
            public ApiResponse<User> apply(Response<UserDto> response) throws Exception {
                return userMapper.transformLogin(response);
            }
        });
    }

    @Override
    public Observable<ApiResponse<User>> loggedUser() {
        ApiResponse<User> apiResponse = new ApiResponse();
        User user = appSession.getLoggedUser();
        if (user != null) {
            apiResponse.setCode(AppConstants.RESPONSE_FROM_CACHE);
            apiResponse.setMessage("");
            apiResponse.setBody(user);
        }
        return Observable.just(apiResponse);
    }
}
