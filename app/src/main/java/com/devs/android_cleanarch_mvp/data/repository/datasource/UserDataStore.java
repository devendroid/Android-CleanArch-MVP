package com.devs.android_cleanarch_mvp.data.repository.datasource;

/**
 * Created by Deven on 2019-09-07.
 */

import com.devs.android_cleanarch_mvp.data.model.UserDto;

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
    Observable<Response<List<UserDto>>> userDtoList();

    /**
     * Get an {@link Observable} which will emit a {@link UserDto} by its id.
     *
     * @param userId The id to retrieve user data.
     */
    Observable<Response<UserDto>> userDtoDetails(final int userId);

}
