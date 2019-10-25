package com.devs.android_cleanarch_mvp.presentation.presenter;

/**
 * Created by Deven on 2019-09-07.
 */

import androidx.annotation.NonNull;

import com.devs.android_cleanarch_mvp.AppConstants;
import com.devs.android_cleanarch_mvp.domain.interactor.GetLoggedUser;
import com.devs.android_cleanarch_mvp.domain.interactor.GetUserLogin;
import com.devs.android_cleanarch_mvp.domain.model.ApiResponse;
import com.devs.android_cleanarch_mvp.domain.model.User;
import com.devs.android_cleanarch_mvp.presentation.model.UserModel;
import com.devs.android_cleanarch_mvp.presentation.model.mapper.UserModelMapper;
import com.devs.android_cleanarch_mvp.presentation.viewer.SplashViewer;
import com.devs.android_cleanarch_mvp.presentation.viewer.UserLoginViewer;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */
public class SplashPresenter implements Presenter {

    private SplashViewer splashViewer;

    private UserModelMapper userModelMapper;

    private GetLoggedUser getLoggedUser;


    @Inject
    public SplashPresenter(GetLoggedUser getLoggedUser, UserModelMapper userModelMapper) {
        this.getLoggedUser = getLoggedUser;
        this.userModelMapper = userModelMapper;
    }

    public void setViewer(@NonNull SplashViewer view) {
        this.splashViewer = view;
    }

    public void checkLoggedUser() {
        this.splashViewer.hideRetry();
        this.splashViewer.showLoading();
        this.requestLoggedUser();
    }

    private void requestLoggedUser() {
        this.getLoggedUser.execute(new UserLoginObserver(), null);
    }

    private void performMappingOnUser(User user) {
        final UserModel userModel =
                this.userModelMapper.transform(user);
        this.splashViewer.showHomeScreen(userModel);
    }

    private final class UserLoginObserver extends DisposableObserver<ApiResponse<User>> {

        @Override public void onComplete() {
            splashViewer.hideLoading();
        }

        @Override public void onError(Throwable e) {
            e.printStackTrace();
            splashViewer.hideLoading();
            splashViewer.showError(e.getMessage());
            splashViewer.showRetry();
        }

        @Override public void onNext(ApiResponse<User> apiResponse) {

           // if(apiResponse.getCode() == 401) {
                // Show Error or something else
           // }
           // else {

            if(apiResponse.getCode() == AppConstants.RESPONSE_FROM_CACHE)
                SplashPresenter.this.performMappingOnUser(apiResponse.getBody());
            else splashViewer.showLoginScreen();

           // }
        }
    }

    //=================Start: Presenter=============
    @Override public void resume() {}

    @Override public void pause() {}

    @Override public void destroy() {
        this.getLoggedUser.dispose();
        this.splashViewer = null;
    }
    //=================End: Presenter=============

}
