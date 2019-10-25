package com.devs.android_cleanarch_mvp.presentation.view.fragment;


import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.devs.android_cleanarch_mvp.R;
import com.devs.android_cleanarch_mvp.presentation.view.activity.HomeActivity;

/**
 * Created by ${Deven} on 29/4/19.
 */
public class UserDetailFrag extends BaseFragment {

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
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((HomeActivity) getActivity()).setSupportActionBar(toolbar);//.initToolbar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.show();
        actionBar.setTitle("User Detail");
        actionBar.setDisplayHomeAsUpEnabled(true);

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
//        this.userListPresenter.setViewer(this);
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