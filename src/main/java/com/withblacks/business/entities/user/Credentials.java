package com.withblacks.business.entities.user;

import org.springframework.stereotype.Component;

@Component
public class Credentials {
    private String login;
    private String password;

    public Credentials(final String login, final String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
