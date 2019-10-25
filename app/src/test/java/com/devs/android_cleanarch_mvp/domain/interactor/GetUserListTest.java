package com.devs.android_cleanarch_mvp.domain.interactor;

import com.devs.android_cleanarch_mvp.domain.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

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

    /**
     * More About verify:
     * https://www.baeldung.com/mockito-verify
     */
    @Test
    public void testGetUserListUseCaseObservableHappyCase() {
        // 1. Call users method
        getUserList.buildUseCaseObservable(null);

        // 2. Verify we called users method
        verify(mockUserRepository, times(1)).users();

        // 3. Verify no more methods remaining that we called in #1 and not verified in #2,
        // Means just check equity of step #1 and #2, We verified all the methods in #2 thats we called in #1 or not.
        verifyNoMoreInteractions(mockUserRepository);
    }
}
