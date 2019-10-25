package com.devs.android_cleanarch_mvp.data.repository.datasource;

/**
 * Created by Deven on 2019-09-07.
 */

import com.devs.android_cleanarch_mvp.data.model.UserDto;
import com.devs.android_cleanarch_mvp.domain.model.ApiResponse;
import com.devs.android_cleanarch_mvp.domain.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface UserDataStore {

    /**
     * Get an {@link Observable} which will emit a List of {@link UserDto}.
     */
    Observable<ApiResponse<List<User>>> userDtoList();

    /**
     * Get an {@link Observable} which will emit a {@link UserDto} by its id.
     *
     * @param userId The id to retrieve user data.
     */
    Observable<ApiResponse<User>> userDtoDetails(final int userId);

    Observable<ApiResponse<User>> userLogin(String username, String password);

    Observable<ApiResponse<User>> loggedUser();

}
