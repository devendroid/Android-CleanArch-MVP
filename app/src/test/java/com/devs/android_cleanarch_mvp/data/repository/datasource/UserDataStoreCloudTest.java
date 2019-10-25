//package com.devs.android_cleanarch_mvp.data.repository.datasource;
//
//import com.devs.android_cleanarch_mvp.data.model.mapper.UserMapper;
//import com.devs.android_cleanarch_mvp.data.remote.RestApi;
//import com.devs.android_cleanarch_mvp.data.remote.RetroClient;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import static org.mockito.Mockito.verify;
//
///**
// * Created by Deven on 2019-10-07.
// */
//@RunWith(MockitoJUnitRunner.class)
//public class UserDataStoreCloudTest {
//
//
//    private UserDataStoreCloud userDataStoreCloud;
//
//    @Mock
//    private UserMapper mockUserMapper;
//    @Mock
//    private RestApi mockRestApi;
//
//    @Before
//    public void setUp() {
//        userDataStoreCloud = new UserDataStoreCloud(mockUserMapper);
//    }
//
//    @Test
//    public void testGetUserEntityListFromApi() {
//        userDataStoreCloud.userDtoList();
//        verify(mockRestApi).userDtoList();
//    }
//
//    @Test
//    public void testGetUserEntityDetailsFromApi() {
//        UserEntity fakeUserEntity = new UserEntity();
//        Observable<UserEntity> fakeObservable = Observable.just(fakeUserEntity);
//        given(mockRestApi.userEntityById(FAKE_USER_ID)).willReturn(fakeObservable);
//
//        cloudUserDataStore.userEntityDetails(FAKE_USER_ID);
//
//        verify(mockRestApi).userEntityById(FAKE_USER_ID);
//    }
//
//}
