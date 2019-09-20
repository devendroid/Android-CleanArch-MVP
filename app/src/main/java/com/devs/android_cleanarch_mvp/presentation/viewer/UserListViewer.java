package com.devs.android_cleanarch_mvp.presentation.viewer;

/**
 * Created by Deven on 2019-09-07.
 */

import com.devs.android_cleanarch_mvp.presentation.model.UserModel;

import java.util.Collection;

/**
 * Interface representing a View in a model view presenter (MVP) pattern.
 * In this case is used as a view representing a list of {@link UserModel}.
 */
public interface UserListViewer extends Viewer {

    /**
     * Render a user list in the UI.
     *
     * @param userModelCollection The collection of {@link UserModel} that will be shown.
     */
    void showUserList(Collection<UserModel> userModelCollection);

    /**
     * View a {@link UserModel} profile/details.
     *
     * @param userModel The user that will be shown.
     */
    void showUser(UserModel userModel);
}
