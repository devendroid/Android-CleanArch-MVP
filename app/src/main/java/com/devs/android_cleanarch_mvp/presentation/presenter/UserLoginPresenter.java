package com.devs.android_cleanarch_mvp.presentation.presenter;

/**
 * Created by Deven on 2019-09-07.
 */

import androidx.annotation.NonNull;

import com.devs.android_cleanarch_mvp.data.cache.AppSession;
import com.devs.android_cleanarch_mvp.domain.interactor.GetUserList;
import com.devs.android_cleanarch_mvp.domain.interactor.GetUserLogin;
import com.devs.android_cleanarch_mvp.domain.model.ApiResponse;
import com.devs.android_cleanarch_mvp.domain.model.User;
import com.devs.android_cleanarch_mvp.presentation.model.UserModel;
import com.devs.android_cleanarch_mvp.presentation.model.mapper.UserModelMapper;
import com.devs.android_cleanarch_mvp.presentation.viewer.UserListViewer;
import com.devs.android_cleanarch_mvp.presentation.viewer.UserLoginViewer;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */
public class UserLoginPresenter implements Presenter {

    private UserLoginViewer userLoginViewer;

    private UserModelMapper userModelMapper;

    private GetUserLogin getUserLoginUseCase;

    @Inject
    AppSession appSession;


    @Inject
    public UserLoginPresenter(GetUserLogin getUserLoginUseCase, UserModelMapper userModelMapper) {
        this.getUserLoginUseCase = getUserLoginUseCase;
        this.userModelMapper = userModelMapper;
    }

    public void setViewer(@NonNull UserLoginViewer view) {
        this.userLoginViewer = view;
    }

    public void loginUser(String username, String password) {
        this.userLoginViewer.hideRetry();
        this.userLoginViewer.showLoading();
        this.requestLogin(username, password);
    }

    private void requestLogin(String username, String password) {
        this.getUserLoginUseCase.execute(new UserLoginObserver(), GetUserLogin.Params.forLogin(username, password));
    }

    private void performMappingOnUser(User user) {
        appSession.setLoggedUser(user);
        final UserModel userModel =
                this.userModelMapper.transform(user);
        this.userLoginViewer.onUserLogin(userModel);
    }

    private final class UserLoginObserver extends DisposableObserver<ApiResponse<User>> {

        @Override public void onComplete() {
            userLoginViewer.hideLoading();
        }

        @Override public void onError(Throwable e) {
            e.printStackTrace();
            userLoginViewer.hideLoading();
            userLoginViewer.showError(e.getMessage());
            userLoginViewer.showRetry();
        }

        @Override public void onNext(ApiResponse<User> apiResponse) {

           // if(apiResponse.getCode() == 401) {
                // Show Error or something else
           // }
           // else {
                UserLoginPresenter.this.performMappingOnUser(apiResponse.getBody());
           // }
        }
    }

    //=================Start: Presenter=============
    @Override public void resume() {}

    @Override public void pause() {}

    @Override public void destroy() {
        this.getUserLoginUseCase.dispose();
        this.userLoginViewer = null;
    }
    //=================End: Presenter=============

}
