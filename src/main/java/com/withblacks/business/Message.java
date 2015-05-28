package com.withblacks.business;

import groovy.transform.CompileStatic;
import org.springframework.stereotype.Component;

@Component
public class Message {

    private String title;
    private StringBuffer content;

    public Message() {
    }

    public Message(final String title, final StringBuffer content) {
        this.title = title;
        this.content = content;
    }

    public final String getTitle() {
        return title;
    }

    public final StringBuffer getContent() {
        return content;
    }
}
