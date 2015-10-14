package com.withblacks.api.business.layers.user;

import com.withblacks.api.business.entities.user.GENDER;
import com.withblacks.api.business.entities.user.User;
import com.withblacks.api.repository.UserRepository;
import com.withblacks.api.rest.utils.MatcherUtils;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.collect.Iterables.size;
import static com.withblacks.api.rest.utils.MatcherUtils.hasProperties;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

public class UserLayerImplTest {

    private UserLayerImpl layer;
    private UserRepository repository;
    private User user;

    @Before
    public void setUp() {
        user = UserMockHelper.mockUser("Iron", "Man", GENDER.MALE);

        repository = mock(UserRepository.class);
        doReturn(user).when(repository).findOne(anyLong());

        layer = new UserLayerImpl(repository);
    }

    @Test
    public void itShouldFindUser() throws Exception {
        MatcherAssert.assertThat(layer.find(1L), MatcherUtils.hasProperties("Iron", "Man", GENDER.MALE));
    }

    @Test
    public void itShouldFindAllUsers() throws Exception {
        doReturn(asList(user, user)).when(repository).findAll();

        assertThat(size(layer.findAll()), is(2));
    }

    @Test
    public void itShouldFindUserByName() throws Exception {
        doReturn(user).when(repository).findByLastName(anyString());

        MatcherAssert.assertThat(layer.find("Iron"), MatcherUtils.hasProperties("Iron", "Man", GENDER.MALE));
    }

    @Test
    public void testCreate() throws Exception {
        doReturn(user).when(repository).save(user);

        MatcherAssert.assertThat(layer.create(user), MatcherUtils.hasProperties("Iron", "Man", GENDER.MALE));
    }

    @Test
    public void testUpdate() throws Exception {
        doReturn(user).when(repository).save(user);

        MatcherAssert.assertThat(layer.update(1L, user), MatcherUtils.hasProperties("Iron", "Man", GENDER.MALE));
    }
}