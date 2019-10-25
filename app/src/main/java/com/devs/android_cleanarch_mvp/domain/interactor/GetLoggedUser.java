package com.devs.android_cleanarch_mvp.domain.interactor;

/*
 * Created by Deven on 2019-09-07.
 */

import com.devs.android_cleanarch_mvp.domain.model.ApiResponse;
import com.devs.android_cleanarch_mvp.domain.model.User;
import com.devs.android_cleanarch_mvp.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link User}.
 */
public class GetLoggedUser extends UseCase<ApiResponse<User>, Void>{

    private UserRepository userRepository;


    @Inject
    public GetLoggedUser(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }


    @Override
    Observable<ApiResponse<User>> buildUseCaseObservable(Void params) {
        return userRepository.loggedUser();
    }

}
