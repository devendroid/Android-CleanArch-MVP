package com.devs.android_cleanarch_mvp.domain.interactor;

/*
 * Created by Deven on 2019-09-07.
 */

import com.devs.android_cleanarch_mvp.domain.model.ApiResponse;
import com.devs.android_cleanarch_mvp.domain.model.User;
import com.devs.android_cleanarch_mvp.domain.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link User}.
 */
public class GetUserList extends UseCase<ApiResponse<List<User>>, Void>{

    private UserRepository userRepository;

    @Inject
    public GetUserList(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    Observable<ApiResponse<List<User>>> buildUseCaseObservable(Void aVoid) {
        return userRepository.users();
    }
}
