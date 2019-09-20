package com.devs.android_cleanarch_mvp.domain.model;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Deven on 2019-09-07.
 */
public class UserTest {

    private static final int FAKE_USER_ID = 8;
    private User user;

    @Before
    public void setUp() {
        user = new User(FAKE_USER_ID);
    }

    @Test
    public void testUserConstructorHappyCase() {
        final int userId = user.getUserId();
        assertThat(userId).isEqualTo(FAKE_USER_ID);
    }
}
