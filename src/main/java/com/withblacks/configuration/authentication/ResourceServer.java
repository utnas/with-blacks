package com.withblacks.configuration.authentication;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(final ResourceServerSecurityConfigurer resources) throws Exception {
        //do something
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        //do something
    }
}