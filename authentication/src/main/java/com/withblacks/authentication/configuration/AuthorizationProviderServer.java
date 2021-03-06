//package com.withblacks.authentication.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//
//import static java.lang.Integer.parseInt;
//
//@Configuration
//@EnableAuthorizationServer
//@PropertySource("classpath:security.properties")
//public class AuthorizationProviderServer extends AuthorizationServerConfigurerAdapter {
//
//    @Value("${security.token.url}")
//    private String redirectionUrl;
//
//    @Value("${security.token.duration}")
//    private String tokenValidityDuration;
//
//    @Value("${security.user.password}")
//    private String password;
//
//    @Value("${security.user.name}")
//    private String userName;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Override
//    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.authenticationManager(authenticationManager);
//    }
//
//    @Override
//    public void configure(final AuthorizationServerSecurityConfigurer security) throws Exception {
//        // do something
//    }
//
//    @Override
//    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
//        //TODO: Should get information from Data source like database or external token provider.
//        clients.inMemory()
//                .withClient(userName)
//                .secret(password)
//                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//                .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//                .scopes("read", "write", "trust")
//                .accessTokenValiditySeconds(60)
//                .and()
//                .withClient("client-with-registered-redirect")
//                .authorizedGrantTypes("authorization_code")
//                .authorities("ROLE_CLIENT")
//                .scopes("read", "trust")
//                .redirectUris(redirectionUrl)
//                .and()
//                .withClient("client-with-secret")
//                .authorizedGrantTypes("client_credentials", "password")
//                .authorities("ROLE_CLIENT")
//                .scopes("read")
//                .secret(password);
//    }
//}
