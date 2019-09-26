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
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devs.android_cleanarch_mvp.R;
import com.devs.android_cleanarch_mvp.data.model.mapper.UserMapper;
import com.devs.android_cleanarch_mvp.data.repository.UserRepositoryImp;
import com.devs.android_cleanarch_mvp.data.repository.datasource.UserDataStoreFactory;
import com.devs.android_cleanarch_mvp.domain.interactor.GetUserList;
import com.devs.android_cleanarch_mvp.domain.repository.UserRepository;
import com.devs.android_cleanarch_mvp.presentation.model.UserModel;
import com.devs.android_cleanarch_mvp.presentation.model.mapper.UserModelMapper;
import com.devs.android_cleanarch_mvp.presentation.presenter.UserListPresenter;
import com.devs.android_cleanarch_mvp.presentation.view.adapter.UserAdapter;
import com.devs.android_cleanarch_mvp.presentation.viewer.UserListViewer;

import java.util.Collection;

/**
 * Created by ${Deven} on 29/4/19.
 */
public class UserDetailFrag extends Fragment {

    private static final String TAG = UserDetailFrag.class.getSimpleName();
    private View parentView;

    private RelativeLayout rlRetry, rlProgress;
    private Button btnRetry;


    @Override
    public void onStart() {
        super.onStart();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            parentView = inflater.inflate(R.layout.frag_user_detail, container, false);

        } catch (InflateException e) {
            e.printStackTrace();
        }
        return parentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Init
        rlRetry = view.findViewById(R.id.rl_retry);
        rlProgress = view.findViewById(R.id.rl_progress);
        btnRetry = view.findViewById(R.id.bt_retry);
        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  userListPresenter.loadUserList();
            }
        });

//        UserDataStoreFactory userDataStoreFactory = new UserDataStoreFactory(context());
//        UserRepository userRepository = new UserRepositoryImp(userDataStoreFactory, new UserMapper());
//        GetUserList getUserList = new GetUserList(userRepository);
//        userListPresenter = new UserListPresenter(getUserList, new UserModelMapper());
//
//        this.userListPresenter.setView(this);
//        if (savedInstanceState == null) {
//            userListPresenter.loadUserList();
//        }
    }

    @Override
    public void onResume() {
        super.onResume();
       // userListPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
       // userListPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
       // userListPresenter.destroy();
    }

    // ================= from : UserListViewer

//    @Override
//    public void showUserList(Collection<UserModel> userModelCollection) {
//        if (userModelCollection != null) {
//            this.usersAdapter.setUsersCollection(userModelCollection);
//        }
//    }
//
//    @Override
//    public void showUser(UserModel userModel) {
//
//    }

//    @Override
//    public void showLoading() {
//        rlProgress.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    public void hideLoading() {
//        rlProgress.setVisibility(View.GONE);
//    }
//
//    @Override
//    public void showRetry() {
//        rlRetry.setVisibility(View.VISIBLE);
//    }
//
//    @Override
//    public void hideRetry() {
//        rlRetry.setVisibility(View.GONE);
//    }
//
//    @Override
//    public void showError(String message) {
//        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public Context context() {
//        return getActivity().getApplicationContext();
//    }
}