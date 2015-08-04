package com.withblacks.business.layers.user;

import com.google.common.collect.Iterables;
import com.withblacks.business.entities.User;
import com.withblacks.repository.user.UserRepository;
import org.junit.Before;
import org.junit.Test;

import static com.withblacks.business.entities.GENDER.MALE;
import static com.withblacks.rest.user.utils.MatcherUtils.hasProperties;
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
        user = UserMockHelper.mockUser("Iron", "Man", MALE);

        repository = mock(UserRepository.class);
        doReturn(user).when(repository).findOne(anyLong());

        layer = new UserLayerImpl(repository);
    }

    @Test
    public void itShouldFindUser() throws Exception {
        assertThat(layer.find(1L), hasProperties("Iron", "Man", MALE));
    }

    @Test
    public void itShouldFindAllUsers() throws Exception {
        doReturn(asList(user, user)).when(repository).findAll();

        assertThat(Iterables.size(layer.findAll()), is(2));
    }

    @Test
    public void itShouldFindUserByName() throws Exception {
        doReturn(user).when(repository).findByLastName(anyString());

        assertThat(layer.find("Iron"), hasProperties("Iron", "Man", MALE));
    }

    @Test
    public void testCreate() throws Exception {
        doReturn(user).when(repository).save(user);

        assertThat(layer.create(user), hasProperties("Iron", "Man", MALE));
    }

    @Test
    public void testUpdate() throws Exception {
        doReturn(user).when(repository).save(user);

        assertThat(layer.update(1L, user), hasProperties("Iron", "Man", MALE));
    }


}