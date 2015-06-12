package com.withblacks.rest

import com.withblacks.rest.user.UserRestFacade
import com.withblacks.rest.user.UserRestFacadeImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static com.withblacks.repository.data.UserGenerator.generateUsersDto
import static org.mockito.Mockito.when
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup

@WebAppConfiguration
@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@ContextConfiguration(classes = [RestMockApplication.class, UserRestFacadeImpl.class])
class UserRestLayerSpec extends Specification {

    @Autowired
    private WebApplicationContext applicationContext;
    private MockMvc mockMvc;
    private UserRestFacade userRestFacade;

    def setup() {
        mockMvc = webAppContextSetup(applicationContext).build();
        when(userRestFacade.findAll()).thenReturn(generateUsersDto(3));
        when(userRestFacade.findById(1L)).thenReturn(new ResponseEntity<?>(generateUsersDto(1)));
    }

    def 'it should find all users'() {
        when:
        def result = mockMvc.perform(get("/users")).andReturn().response.getContentAsString()

        then:
        result == "[{\"firstName\":null,\"lastName\":null,\"gender\":null}]"
    }

    void testFindAll() {

    }

    void testFindByName() {

    }

    void testFindById() {

    }

    void testCreate() {

    }

    void testUpdate() {

    }

    void testDelete() {

    }
}
