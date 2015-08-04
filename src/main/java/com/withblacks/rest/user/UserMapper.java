package com.withblacks.rest.user;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private DozerBeanMapper mapper;

    public UserMapper() {
        mapper = new DozerBeanMapper();
    }
}
