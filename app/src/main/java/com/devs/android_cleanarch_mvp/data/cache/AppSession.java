package com.devs.android_cleanarch_mvp.data.cache;

import android.content.Context;
import android.content.SharedPreferences;

import com.devs.android_cleanarch_mvp.domain.model.User;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Deven on 2019-09-27.
 */
@Singleton
public class AppSession {

    private static final String SESSION_NAME = "com.devs.autocallrecorder.AppSession";
    public static final String APP_DEFAULT_LANGUAGE = "en";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor prefsEditor;

    @Inject
    AppSession(Context context){
        mSharedPreferences = context.getSharedPreferences(SESSION_NAME,
                Context.MODE_PRIVATE);

    }

    public User getCachedUser(int userId) {

        return null;
    }

    public void setLoggedUser(User user) {
        prefsEditor = mSharedPreferences.edit();
        prefsEditor.putString("LoggedUser", new Gson().toJson(user));
        prefsEditor.commit();
    }

    public User getLoggedUser() {
        User user = new Gson().fromJson(mSharedPreferences.getString("LoggedUser", null),
                User.class);
        return user;
    }
}
