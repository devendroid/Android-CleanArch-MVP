package com.devs.android_cleanarch_mvp.data.model.mapper;

/**
 * Created by Deven on 2019-09-07.
 */

import com.devs.android_cleanarch_mvp.data.model.UserDto;
import com.devs.android_cleanarch_mvp.domain.model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

/**
 * Mapper class used to transform {@link UserDto} (in the data layer) to {@link User} in the
 * domain layer.
 */
public class UserMapper {

    /**
     * Transform a {@link UserDto} into an {@link User}.
     *
     * @param userEntity Object to be transformed.
     * @return {@link User} if valid {@link UserDto} otherwise null.
     */
    public User transform(UserDto userEntity) {
        User user = null;
        if (userEntity != null) {
            user = new User(userEntity.getUserId());
            user.setCoverUrl(userEntity.getCoverUrl());
            user.setFullName(userEntity.getFullname());
            user.setDescription(userEntity.getDescription());
            user.setFollowers(userEntity.getFollowers());
            user.setEmail(userEntity.getEmail());
        }
        return user;
    }

    /**
     * Transform a List of {@link UserDto} into a Collection of {@link User}.
     *
     * @param userEntityCollection Object Collection to be transformed.
     * @return {@link User} if valid {@link UserDto} otherwise null.
     */
    public List<User> transform(Response<List<UserDto>> userEntityCollection) {

        final List<User> userList = new ArrayList<>();
        if (userEntityCollection.body() != null) {
            for (UserDto userEntity : userEntityCollection.body()) {
                final User user = transform(userEntity);
                if (user != null) {
                    userList.add(user);
                }
            }
        }
        return userList;
    }
}
