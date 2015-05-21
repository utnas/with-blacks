package com.withblacks.business;

public class Message {

    private final String title;
    private final StringBuffer content;

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
