package com.withblacks.repository;

import com.withblacks.business.entities.user.User;
import com.withblacks.facade.user.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Config.class})
@WebIntegrationTest("server.port:9000")
public class ConfigTest {

    RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void shouldAddAppUserToDb() {
        ResponseEntity<UserDto> responseEntity = restTemplate.postForEntity("http://localhost:9000/user/Iron", MockHttpServletRequest.DEFAULT_PROTOCOL, UserDto.class);
        final UserDto appUser = responseEntity.getBody();
        assertThat(appUser.getFirstName(), is("Abderrazak BOUADMA"));
    }
}