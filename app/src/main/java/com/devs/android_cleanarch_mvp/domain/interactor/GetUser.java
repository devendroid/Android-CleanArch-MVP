package com.devs.android_cleanarch_mvp.domain.interactor;

/*
 * Created by Deven on 2019-09-07.
 */

import com.devs.android_cleanarch_mvp.domain.model.ApiResponse;
import com.devs.android_cleanarch_mvp.domain.model.User;
import com.devs.android_cleanarch_mvp.domain.repository.UserRepository;

import java.util.List;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link User}.
 */
public class GetUser extends UseCase<ApiResponse<User>, GetUser.Params>{

    private UserRepository userRepository;


    public GetUser(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }


    @Override
    Observable<ApiResponse<User>> buildUseCaseObservable(GetUser.Params params) {
        return userRepository.user(params.userId);
    }

    public static final class Params {

        private final int userId;

        private Params(int userId) {
            this.userId = userId;
        }

        public static Params forUser(int userId) {
            return new Params(userId);
        }
    }
}
