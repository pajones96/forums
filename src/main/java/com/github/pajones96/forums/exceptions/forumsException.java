package com.github.pajones96.forums.exceptions;

import org.springframework.mail.MailException;

public class forumsException extends Throwable {
    public forumsException(String s, MailException e) {
    }
}
