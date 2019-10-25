package com.devs.android_cleanarch_mvp.data.repository.datasource;

import android.content.Context;

import com.devs.android_cleanarch_mvp.data.cache.AppSession;
import com.devs.android_cleanarch_mvp.data.model.mapper.UserMapper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Created by Deven on 2019-10-07.
 */
public class UserDataStoreFactoryTest {

    private static final int FAKE_USER_ID = 11;

    private UserDataStoreFactory userDataStoreFactory;

    @Mock private UserMapper mockUserMapper;
    @Mock private Context context;

    @Before
    public void setUp() {
        userDataStoreFactory = new UserDataStoreFactory(context, mockUserMapper);
    }

    @Test
    public void testCreatCloudDataStore() {

        UserDataStore userDataStore = userDataStoreFactory.createDataStoreCloud();

        assertThat(userDataStore, is(notNullValue()));
        assertThat(userDataStore, is(instanceOf(UserDataStoreCloud.class)));

    }

    @Test
    public void testCreateDiskDataStore() {

        UserDataStore userDataStore = userDataStoreFactory.createDataStoreDisk();

        assertThat(userDataStore, is(notNullValue()));
        assertThat(userDataStore, is(instanceOf(UserDataStoreDisk.class)));

    }

}
