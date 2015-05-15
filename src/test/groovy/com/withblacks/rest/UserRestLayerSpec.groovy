package com.withblacks.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup

@WebAppConfiguration
@ContextConfiguration(classes = [RestMockApplication.class, UserRestLayer.class])
class UserRestLayerSpec extends Specification {

    @Autowired
    private WebApplicationContext applicationContext;
    private MockMvc mockMvc;

    def setup() {
        mockMvc = webAppContextSetup(applicationContext).build();
    }

    def 'it should find all users'() {

        when:
        def result = mockMvc.perform(get("/users/")).andReturn().response.getContentAsString()

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
