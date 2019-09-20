package com.devs.android_cleanarch_mvp.data.repository;

/**
 * Created by Deven on 2019-09-07.
 */

import com.devs.android_cleanarch_mvp.data.model.UserDto;
import com.devs.android_cleanarch_mvp.data.model.mapper.UserMapper;
import com.devs.android_cleanarch_mvp.data.repository.datasource.UserDataStore;
import com.devs.android_cleanarch_mvp.data.repository.datasource.UserDataStoreFactory;
import com.devs.android_cleanarch_mvp.domain.model.User;
import com.devs.android_cleanarch_mvp.domain.repository.UserRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import retrofit2.Response;

/**
 * {@link UserRepository} for retrieving user data.
 */
public class UserRepositoryImp implements UserRepository {

    private final UserDataStoreFactory userDataStoreFactory;
    private UserMapper userMapper;

    public UserRepositoryImp(UserDataStoreFactory userDataStoreFactory, UserMapper userMapper ) {
        this.userDataStoreFactory = userDataStoreFactory;
        this.userMapper = userMapper;
    }

    @Override
    public Observable<List<User>> users() {
        //we always get all users from the cloud
        final UserDataStore userDataStore = this.userDataStoreFactory.createDataStoreCloud();


        // Performing transformation from Response<List<UserDto>> to List<User> inside Observable
        // Using Simple java code======

        return userDataStore.userDtoList().map(new Function<Response<List<UserDto>>, List<User>>() {
            @Override
            public List<User> apply(Response<List<UserDto>> listResponse) throws Exception {
                return UserRepositoryImp.this.userMapper.transform(listResponse);
            }
        });

        // OR Make shorthand it using lambda expression of Java 8=====
    //  return userDataStore.userDtoList().map(s -> this.userMapper.transform(s));

        // OR Make more shorthand it using method reference of Java 8=====
    //    return userDataStore.userDtoList().map(this.userMapper::transform);

    }

    @Override
    public Observable<User> user(int userId) {
        return null;
    }

}
