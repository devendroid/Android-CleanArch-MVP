package com.devs.android_cleanarch_mvp.presentation.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.devs.android_cleanarch_mvp.MyApplication;
import com.devs.android_cleanarch_mvp.R;
import com.devs.android_cleanarch_mvp.presentation.navigation.Navigator;
import com.devs.android_cleanarch_mvp.presentation.utils.Utilities;
import com.devs.android_cleanarch_mvp.presentation.view.fragment.UserListFrag;
import com.google.android.material.navigation.NavigationView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Inject  Navigator navigator;

    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication)getApplication()).getAppComponent().inject(this);

        navigator.replaceFragment(this,R.id.fragment_container, new UserListFrag());

    }

    public void initToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        View view = navigationView.getHeaderView(0);
        ((TextView)view.findViewById(R.id.tv_ver))
                .setText(String.format("Version %s", Utilities.getInstance(this).getAppVersion()));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.nav_home:
                navigator.replaceFragment(this,R.id.fragment_container, new UserListFrag());
                break;

            case R.id.nav_profile:

                break;

            case R.id.nav_settings:
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu_home) {
        //Log.i(TAG, "onCreateOptionsMenu");
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_home, menu_home);

        return super.onCreateOptionsMenu(menu_home);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Log.i(TAG, "onOptionsItemSelected");
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the HomeActivity/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                navigator.popFragment(this);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
