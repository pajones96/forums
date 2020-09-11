package com.github.pajones96.forums.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@AllArgsConstructor
public class MailContentBuilder {

    private final TemplateEngine templateEngine;

    /**
     * Takes the message that is to be sent to the user as input.
     * @param message
     * @return
     */
    String build(String message){
        Context context = new Context();
        //sets the message
        context.setVariable("message", message);
        //passes html filename and context to Thymeleaf's template engine
        return templateEngine.process("mailTemplate", context);
        //at run-time, automatically adds email message to template
    }
}
