package com.devs.android_cleanarch_mvp.presentation.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

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


public class UserListActivity extends AppCompatActivity implements UserListViewer {


    private RecyclerView recyclerView;
    private RelativeLayout rlRetry, rlProgress;
    private Button btnRetry;

    private UserListPresenter userListPresenter;
    private UserAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        // Init
        recyclerView = findViewById(R.id.rv_users);
        usersAdapter = new UserAdapter(context());
        //usersAdapter.setOnItemClickListener(onItemClickListener);
        recyclerView.setLayoutManager(new LinearLayoutManager(context()));
        recyclerView.setAdapter(usersAdapter);
        rlRetry = findViewById(R.id.rl_retry);
        rlProgress = findViewById(R.id.rl_progress);
        btnRetry = findViewById(R.id.bt_retry);
        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        UserDataStoreFactory userDataStoreFactory = new UserDataStoreFactory(context());
        UserRepository userRepository = new UserRepositoryImp(userDataStoreFactory, new UserMapper());
        GetUserList getUserList = new GetUserList(userRepository);
        userListPresenter = new UserListPresenter(getUserList, new UserModelMapper());

        this.userListPresenter.setView(this);
        if (savedInstanceState == null) {
            userListPresenter.loadUserList();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        userListPresenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        userListPresenter.pause();
    }

    @Override
    protected void onDestroy() {
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
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context context() {
        return getApplicationContext();
    }

}
