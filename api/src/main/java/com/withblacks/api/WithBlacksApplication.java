package com.withblacks.api;

/**
 * After you launch the app, you can seek a bearer token like this:
 * <p>
 * <pre>
 * curl localhost:8080/oauth/token -d "grant_type=password&scope=write&username=user&password=pwd" -u user:pwd
 * </pre>
 * <ul>
 * <li>grant_type=password (user credentials will be supplied)</li>
 * <li>scope=read (or write | trusted)</li>
 * <li>username=user (username checked against user details service)</li>
 * <li>password=pwd (password checked against user details service)</li>
 * <li>-u user:pwd (clientid:user)</li>
 * </ul>
 * <p>
 * Response should be similar to this:
 * <code>{"access_token":"533de99b-5a0f-4175-8afd-1a64feb952d5","token_type":"bearer","expires_in":43199,"scope":"read"}</code>
 * <p>
 * With the token value, you can now interrogate the RESTful interface like this:
 * <p>
 * <pre>
 * curl -H "Authorization: bearer YOUR_ACCESS_TOKEN" localhost:8080/users
 * </pre>
 */

import com.withblacks.api.business.seeds.Seed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAutoConfiguration
public class WithBlacksApplication implements ApplicationRunner {

    @Autowired
    private Seed seed;

    public static void main(String[] args) {
        SpringApplication.run(WithBlacksApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        seed.populate();
    }
}