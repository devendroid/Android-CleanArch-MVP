package com.devs.android_cleanarch_mvp.presentation.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.devs.android_cleanarch_mvp.MyApplication;
import com.devs.android_cleanarch_mvp.R;
import com.devs.android_cleanarch_mvp.data.cache.AppSession;
import com.devs.android_cleanarch_mvp.data.model.mapper.UserMapper;
import com.devs.android_cleanarch_mvp.data.repository.UserRepositoryImp;
import com.devs.android_cleanarch_mvp.data.repository.datasource.UserDataStoreFactory;
import com.devs.android_cleanarch_mvp.domain.interactor.GetUserLogin;
import com.devs.android_cleanarch_mvp.domain.repository.UserRepository;
import com.devs.android_cleanarch_mvp.presentation.model.UserModel;
import com.devs.android_cleanarch_mvp.presentation.model.mapper.UserModelMapper;
import com.devs.android_cleanarch_mvp.presentation.navigation.Navigator;
import com.devs.android_cleanarch_mvp.presentation.presenter.UserListPresenter;
import com.devs.android_cleanarch_mvp.presentation.presenter.UserLoginPresenter;
import com.devs.android_cleanarch_mvp.presentation.view.activity.HomeActivity;
import com.devs.android_cleanarch_mvp.presentation.viewer.UserLoginViewer;
import com.google.android.material.button.MaterialButton;

import javax.inject.Inject;

/**
 * Created by ${Deven} on 29/4/19.
 */
public class LoginFrag extends BaseFragment implements UserLoginViewer {

    private static final String TAG = LoginFrag.class.getSimpleName();
    private View parentView;

    @Inject
    Navigator navigator;

    @Inject
    UserLoginPresenter userLoginPresenter;

    private RelativeLayout rlProgress;

    @Override
    public void onStart() {
        super.onStart();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            parentView = inflater.inflate(R.layout.frag_login, container, false);

        } catch (InflateException e) {
            e.printStackTrace();
        }
        return parentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((MyApplication)getActivity().getApplication()).getAppComponent().inject(this);

        // these objects are injected
//        UserDataStoreFactory userDataStoreFactory = new UserDataStoreFactory(context(), new UserMapper(), new AppSession() );
//        UserRepository userRepository = new UserRepositoryImp(userDataStoreFactory, new AppSession() );
//        GetUserLogin getUserLogin = new GetUserLogin(userRepository);
//        userLoginPresenter = new UserLoginPresenter(getUserLogin, new UserModelMapper());

        this.userLoginPresenter.setViewer(this);

        rlProgress = view.findViewById(R.id.rl_progress);
       view.findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLoginPresenter.loginUser("","");
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        userLoginPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        userLoginPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        userLoginPresenter.destroy();
    }

   //==================

    @Override
    public void onUserLogin(UserModel userModel) {
        navigator.startNewActivity(getActivity(), HomeActivity.class);
        getActivity().finish();
    }

    @Override
    public void showLoading() {
        rlProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        rlProgress.setVisibility(View.GONE);
    }

    @Override
    public void showRetry() {
        //rlRetry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        //rlRetry.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return getActivity().getApplicationContext();
    }
}