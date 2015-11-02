package com.withblacks.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

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
 * curl -H "Authorization: bearer 0e989400-6bcd-45c8-8bc2-596f38451891" localhost:8080/users
 * </pre>
 */

@SpringBootApplication
@EnableDiscoveryClient
@Enabl
public class WithBlacksAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(WithBlacksAuthenticationApplication.class, args);
    }
}