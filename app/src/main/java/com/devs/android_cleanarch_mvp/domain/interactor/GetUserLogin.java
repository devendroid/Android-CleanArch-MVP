package com.devs.android_cleanarch_mvp.domain.interactor;

/*
 * Created by Deven on 2019-09-07.
 */

import android.text.PrecomputedText;

import com.devs.android_cleanarch_mvp.domain.model.ApiResponse;
import com.devs.android_cleanarch_mvp.domain.model.User;
import com.devs.android_cleanarch_mvp.domain.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * retrieving a collection of all {@link User}.
 */
public class GetUserLogin extends UseCase<ApiResponse<User>, GetUserLogin.Params>{

    private UserRepository userRepository;


    @Inject
    public GetUserLogin(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }


    @Override
    Observable<ApiResponse<User>> buildUseCaseObservable(GetUserLogin.Params params) {
        return userRepository.userLogin(params.userName, params.password);
    }


    public static final class Params {

        private final String userName;
        private final String password;

        private Params(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public static Params forLogin(String userName, String password) {
            return new Params(userName, password);
        }
    }


}
