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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devs.android_cleanarch_mvp.MyApplication;
import com.devs.android_cleanarch_mvp.R;
import com.devs.android_cleanarch_mvp.data.repository.datasource.UserDataStoreFactory;
import com.devs.android_cleanarch_mvp.domain.interactor.GetUserList;
import com.devs.android_cleanarch_mvp.domain.repository.UserRepository;
import com.devs.android_cleanarch_mvp.presentation.model.UserModel;
import com.devs.android_cleanarch_mvp.presentation.model.mapper.UserModelMapper;
import com.devs.android_cleanarch_mvp.presentation.navigation.Navigator;
import com.devs.android_cleanarch_mvp.presentation.presenter.UserListPresenter;
import com.devs.android_cleanarch_mvp.presentation.view.activity.HomeActivity;
import com.devs.android_cleanarch_mvp.presentation.view.adapter.UserAdapter;
import com.devs.android_cleanarch_mvp.presentation.viewer.UserListViewer;

import java.util.Collection;

import javax.inject.Inject;

/**
 * Created by ${Deven} on 29/4/19.
 */
public class UserListFrag extends BaseFragment implements UserListViewer {

    private static final String TAG = UserListFrag.class.getSimpleName();
    private View parentView;

    @Inject
    protected Navigator navigator;

//    @Inject
//    UserDataStoreFactory userDataStoreFactory;
//    @Inject
//    UserRepository userRepository;
//    @Inject
//    GetUserList getUserList;
//    @Inject
//    UserModelMapper userModelMapper;
    @Inject
    UserListPresenter userListPresenter;

    private RecyclerView recyclerView;
    private RelativeLayout rlRetry, rlProgress;
    private Button btnRetry;


    private UserAdapter usersAdapter;

    @Override
    public void onStart() {
        super.onStart();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        try {
            parentView = inflater.inflate(R.layout.frag_user_list, container, false);

        } catch (InflateException e) {
            e.printStackTrace();
        }
        return parentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((MyApplication)getActivity().getApplication()).getAppComponent().inject(this);

        // Init
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((HomeActivity) getActivity()).initToolbar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.show();
        actionBar.setTitle("Home");

        recyclerView = view.findViewById(R.id.rv_users);
        usersAdapter = new UserAdapter(context());
        usersAdapter.setOnItemClickListener(new UserAdapter.OnItemClickListener(){
            @Override
            public void onUserItemClicked(UserModel userModel) {
                navigator.addFragmentWithBack(getActivity(),R.id.fragment_container,
                        new UserDetailFrag());
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(context()));
        recyclerView.setAdapter(usersAdapter);
        rlRetry = view.findViewById(R.id.rl_retry);
        rlProgress = view.findViewById(R.id.rl_progress);
        btnRetry = view.findViewById(R.id.bt_retry);
        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userListPresenter.loadUserList();
            }
        });

        // these objects are injected
        //UserDataStoreFactory userDataStoreFactory = new UserDataStoreFactory(context(), new UserMapper(), new AppSession() );
        //UserRepository userRepository = new UserRepositoryImp(userDataStoreFactory, new AppSession() );
        //GetUserList getUserList = new GetUserList(userRepository);
        //userListPresenter = new UserListPresenter(getUserList, userModelMapper);

        this.userListPresenter.setViewer(this);
        if (savedInstanceState == null) {
            userListPresenter.loadUserList();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        userListPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        userListPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        userListPresenter.destroy();
    }

    // ================= from : UserListViewer

    @Override
    public void showUserList(Collection<UserModel> userModelCollection) {
        if (userModelCollection != null) {
            this.usersAdapter.setUsersCollection(userModelCollection);
        }
    }

    @Override
    public void showUser(UserModel userModel) {

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
        rlRetry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        rlRetry.setVisibility(View.GONE);
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