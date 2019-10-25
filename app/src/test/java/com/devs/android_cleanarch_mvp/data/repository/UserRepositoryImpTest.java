//package com.devs.android_cleanarch_mvp.data.repository;
//
//import android.content.Context;
//
//import com.devs.android_cleanarch_mvp.data.cache.AppSession;
//import com.devs.android_cleanarch_mvp.data.model.UserDto;
//import com.devs.android_cleanarch_mvp.data.model.mapper.UserMapper;
//import com.devs.android_cleanarch_mvp.data.repository.datasource.UserDataStore;
//import com.devs.android_cleanarch_mvp.data.repository.datasource.UserDataStoreFactory;
//import com.devs.android_cleanarch_mvp.domain.model.ApiResponse;
//import com.devs.android_cleanarch_mvp.domain.model.User;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import io.reactivex.Observable;
//
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.verify;
//
///**
// * Created by Deven on 2019-10-07.
// */
//@RunWith(MockitoJUnitRunner.class)
//public class UserRepositoryImpTest {
//
//    private static final int FAKE_USER_ID = 123;
//
//    private UserRepositoryImp userRepositoryImp;
//    private UserDataStoreFactory userDataStoreFactory;
//
//    @Mock private AppSession mockAppSession;
//    @Mock private UserDataStore mockUserDataStore;
//    @Mock private User mockUser;
//    @Mock private Context mockContext;
//    @Mock private UserMapper mockUserMapper;
//
//    @Before
//    public void setup(){
//        userDataStoreFactory = new UserDataStoreFactory(mockContext, mockUserMapper);
//        userRepositoryImp = new UserRepositoryImp(userDataStoreFactory, mockAppSession);
//      //  given(userDataStoreFactory.createDataStoreDisk()).willReturn(mockUserDataStore);
//        given(mockAppSession.getCachedUser(anyInt())).willReturn(mockUser);
//    }
//
//    @Test
//    public void testGetUsersHappyCase() {
//        ApiResponse apiResponse = createDummyApiResponse();
//
//        given(mockUserDataStore.userDtoList()).willReturn(Observable.just(apiResponse));
//
//        userRepositoryImp.users();
//        userDataStoreFactory.createDataStoreCloud();
//
//      //  verify(mockUserDataStore).userDtoList();
//    }
//
//    @Test
//    public void testGetUserHappyCase() {
//        UserEntity userEntity = new UserEntity();
//        given(mockUserDataStore.userEntityDetails(FAKE_USER_ID)).willReturn(Observable.just(userEntity));
//        userDataRepository.user(FAKE_USER_ID);
//
//        verify(mockUserDataStoreFactory).create(FAKE_USER_ID);
//        verify(mockUserDataStore).userEntityDetails(FAKE_USER_ID);
//    }
//
//    private ApiResponse createDummyApiResponse(){
//        List<UserDto> usersList = new ArrayList();
//        usersList.add(new UserDto());
//        ApiResponse apiResponse = new ApiResponse<UserDto>();
//        apiResponse.setBody(usersList);
//        return apiResponse;
//    }
//
//}
