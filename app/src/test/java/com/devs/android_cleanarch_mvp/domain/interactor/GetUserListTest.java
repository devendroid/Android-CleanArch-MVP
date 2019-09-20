package com.devs.android_cleanarch_mvp.domain.interactor;

import com.devs.android_cleanarch_mvp.domain.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by Deven on 2019-09-07.
 */
@RunWith(MockitoJUnitRunner.class)
public class GetUserListTest {

    private GetUserList getUserList;

    @Mock private UserRepository mockUserRepository;

    @Before
    public void setUp() {
        getUserList = new GetUserList(mockUserRepository);
    }

    @Test
    public void testGetUserListUseCaseObservableHappyCase() {
        getUserList.buildUseCaseObservable(null);

        verify(mockUserRepository).users();
        verifyNoMoreInteractions(mockUserRepository);
    }
}
