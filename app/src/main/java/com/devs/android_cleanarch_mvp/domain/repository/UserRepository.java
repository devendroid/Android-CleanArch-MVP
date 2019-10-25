package com.devs.android_cleanarch_mvp.domain.repository;

/**
 * Created by Deven on 2019-09-07.
 */

import com.devs.android_cleanarch_mvp.domain.model.ApiResponse;
import com.devs.android_cleanarch_mvp.domain.model.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Interface that represents a Repository for getting {@link User} related data.
 */
public interface UserRepository {

    /**
     * Get an {@link Observable} which will emit a List of {@link User}.
     */
    Observable<ApiResponse<List<User>>> users();

    /**
     * Get an {@link Observable} which will emit a {@link User}.
     *
     * @param userId The user id used to retrieve user data.
     */
    Observable<ApiResponse<User>> user(final int userId);


    Observable<ApiResponse<User>> loggedUser();

    Observable<ApiResponse<User>> userLogin(String username, String password);

}
