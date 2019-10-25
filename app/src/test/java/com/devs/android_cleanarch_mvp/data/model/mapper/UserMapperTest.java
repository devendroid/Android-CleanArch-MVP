package com.devs.android_cleanarch_mvp.data.model.mapper;

import com.devs.android_cleanarch_mvp.data.model.UserDto;
import com.devs.android_cleanarch_mvp.domain.model.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Deven on 2019-10-07.
 */

@RunWith(MockitoJUnitRunner.class)
public class UserMapperTest {

    private static final int FAKE_USER_ID = 123;
    private static final String FAKE_FULLNAME = "Tony Stark";

    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        userMapper = new UserMapper();
    }

    @Test
    public void transformFromUserDto(){
        UserDto userDto = createFakeUserDto();
        User user = userMapper.transform(userDto);

        assertThat(user, is(instanceOf(User.class)));
        assertThat(user.getUserId(), is(FAKE_USER_ID));
        assertThat(user.getFullName(), is(FAKE_FULLNAME));

    }

//    @Test
//    public void testTransformUserEntityCollection() {
//        UserEntity mockUserEntityOne = mock(UserEntity.class);
//        UserEntity mockUserEntityTwo = mock(UserEntity.class);
//
//        List<UserEntity> userEntityList = new ArrayList<UserEntity>(5);
//        userEntityList.add(mockUserEntityOne);
//        userEntityList.add(mockUserEntityTwo);
//
//        Collection<User> userCollection = userEntityDataMapper.transform(userEntityList);
//
//        assertThat(userCollection.toArray()[0], is(instanceOf(User.class)));
//        assertThat(userCollection.toArray()[1], is(instanceOf(User.class)));
//        assertThat(userCollection.size(), is(2));
//    }


    private UserDto createFakeUserDto() {
        UserDto userEntity = new UserDto();
        userEntity.setUserId(FAKE_USER_ID);
        userEntity.setFullname(FAKE_FULLNAME);
        return userEntity;
    }

}
