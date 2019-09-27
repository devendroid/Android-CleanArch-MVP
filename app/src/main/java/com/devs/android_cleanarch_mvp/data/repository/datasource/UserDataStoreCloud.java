package com.devs.android_cleanarch_mvp.data.repository.datasource;

import com.devs.android_cleanarch_mvp.data.model.UserDto;
import com.devs.android_cleanarch_mvp.data.model.mapper.UserMapper;
import com.devs.android_cleanarch_mvp.data.remote.RetroClient;
import com.devs.android_cleanarch_mvp.data.repository.UserRepositoryImp;
import com.devs.android_cleanarch_mvp.domain.model.ApiResponse;
import com.devs.android_cleanarch_mvp.domain.model.User;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;
import retrofit2.Response;

/**
 * Created by Deven on 2019-09-07.
 */
/**
 * {@link UserDataStore} implementation based on connections to the api (Cloud).
 */
public class UserDataStoreCloud implements  UserDataStore {
    private UserMapper userMapper;

    public UserDataStoreCloud(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Observable<ApiResponse<List<User>>> userDtoList() {

        // Performing transformation from Response<List<UserDto>> to ApiResponse<List<User>> inside Observable
        // Using Simple java code======
        Observable<Response<List<UserDto>>> observable = RetroClient.restApi().userDtoList();

        return observable.map(new Function<Response<List<UserDto>>, ApiResponse<List<User>>>() {
            @Override
            public ApiResponse<List<User>> apply(Response<List<UserDto>> listResponse) throws Exception {
                return UserDataStoreCloud.this.userMapper.transform(listResponse);
            }
        });

        // OR Make shorthand it using lambda expression of Java 8=====
        //  return userDataStore.userDtoList().map(s -> this.userMapper.transform(s));

        // OR Make more shorthand it using method reference of Java 8=====
        //    return userDataStore.userDtoList().map(this.userMapper::transform);


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
