package com.withblacks.business.entity;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MessageTest {

    @Test
    public void testItShouldGetTitleOfMessage() throws Exception {
        final Message message = new Message("I'm yours", new StringBuffer("The content of the message"));
        assertThat(message.getTitle(), is("I'm yours"));
    }

    @Test
    public void testGetContent() throws Exception {
        final Message message = new Message("I'm yours", new StringBuffer("The content of the message"));
        assertThat(message.getContent().toString(), is("The content of the message"));
    }
}