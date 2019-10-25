package com.devs.android_cleanarch_mvp.presentation.presenter;

/**
 * Created by Deven on 2019-09-07.
 */

import androidx.annotation.NonNull;

import com.devs.android_cleanarch_mvp.domain.interactor.GetUserList;
import com.devs.android_cleanarch_mvp.domain.model.ApiResponse;
import com.devs.android_cleanarch_mvp.domain.model.User;
import com.devs.android_cleanarch_mvp.presentation.model.UserModel;
import com.devs.android_cleanarch_mvp.presentation.model.mapper.UserModelMapper;
import com.devs.android_cleanarch_mvp.presentation.viewer.UserListViewer;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.observers.DisposableObserver;

/**
 * {@link Presenter} that controls communication between views and models of the presentation
 * layer.
 */
public class UserListPresenter implements Presenter {

    private UserListViewer userListViewer;

    private UserModelMapper userModelMapper;

    private GetUserList getUserListUseCase;


    @Inject
    public UserListPresenter(GetUserList getUserListUseCase, UserModelMapper userModelMapper) {
        this.getUserListUseCase = getUserListUseCase;
        this.userModelMapper = userModelMapper;
    }

    public void setViewer(@NonNull UserListViewer view) {
        this.userListViewer = view;
    }

    public void loadUserList() {
        this.userListViewer.hideRetry();
        this.userListViewer.showLoading();
        this.requestUserList();
    }

    private void requestUserList() {
        this.getUserListUseCase.execute(new UserListObserver(), null);
    }

    private void performMappingOnUserList(Collection<User> usersCollection) {
        final Collection<UserModel> userModelsCollection =
                this.userModelMapper.transform(usersCollection);
        this.userListViewer.showUserList(userModelsCollection);
    }

    private final class UserListObserver extends DisposableObserver<ApiResponse<List<User>>> {

        @Override public void onComplete() {
            userListViewer.hideLoading();
        }

        @Override public void onError(Throwable e) {
            userListViewer.hideLoading();
            userListViewer.showError(e.getMessage());
            userListViewer.showRetry();
        }

        @Override public void onNext(ApiResponse<List<User>> apiResponse) {

           // if(apiResponse.getCode() == 401) {
                // Show Error or something else
           // }
           // else {
                UserListPresenter.this.performMappingOnUserList(apiResponse.getBody());
           // }
        }
    }

    //=================Start: Presenter=============
    @Override public void resume() {}

    @Override public void pause() {}

    @Override public void destroy() {
        this.getUserListUseCase.dispose();
        this.userListViewer = null;
    }
    //=================End: Presenter=============




}
