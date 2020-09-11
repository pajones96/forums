package com.github.pajones96.forums.service;

import com.github.pajones96.forums.exceptions.forumsException;
import com.github.pajones96.forums.model.NotificationEmail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender mailSender;
    private final MailContentBuilder mailContentBuilder;

    @Async
    void sendMail(NotificationEmail notificationEmail) throws forumsException {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            //Replace this bit later with a proper SMTP server email address
            messageHelper.setFrom("springreddit@email.com");
            messageHelper.setTo(notificationEmail.getRecipient());
            messageHelper.setSubject(notificationEmail.getSubject());
            messageHelper.setText(notificationEmail.getBody());
        };
        try {
            mailSender.send(messagePreparator);
            log.info("Activation email sent!!");
        } catch (MailException e) {
            log.error("Exception occurred when sending mail", e);
            //This bit right here vvv kept giving me an unhandled exception notification
            //Which was annoying, but it matched the github repo of the tutorial I'm using
            //So I've added what I assume is the least intrusive fix, which is that the
            //method now has a throw clause. This miiight be an IDE issue, not sure yet.
            throw new forumsException("Exception occurred when sending mail to " + notificationEmail.getRecipient(), e);
        }
    }
}
