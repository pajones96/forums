package com.github.pajones96.forums.exceptions;


import org.springframework.mail.MailException;

public class forumsException extends RuntimeException {
    public forumsException(String exMessage, MailException e) {
        super(exMessage);
    }
}
