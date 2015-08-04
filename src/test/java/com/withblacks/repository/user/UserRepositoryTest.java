package com.withblacks.repository.user;

import com.withblacks.business.entities.GENDER;
import com.withblacks.business.entities.User;
import org.junit.Before;
import org.junit.Test;

import static com.withblacks.business.builder.UserBuilder.build;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class UserRepositoryTest {

    private UserRepository repository;
    User user;

    @Before
    public void setUp() throws Exception {
        user = build("FirstName", "LastName", GENDER.FEMALE);
        repository = mock(UserRepository.class);
        doReturn(user).when(repository).save(any(User.class));
    }

    @Test
    public void testFindById() throws Exception {
        user = repository.save(user);

        assertThat(null, is(repository.findOne(user.getId())));
    }

    @Test
    public void testFindByLastName() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {

    }
}
