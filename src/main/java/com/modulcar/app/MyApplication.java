package com.modulcar.app;

import com.modulcar.domain.Message;
import com.modulcar.AppConfiguration;
import com.modulcar.service.SmsService;
import com.modulcar.service.MailService;
import com.modulcar.service.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MyApplication {
    public static void main(String[] args) {
        Message message = new Message();
        message.setMessage("Spring ile uygulama geliştirme");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        MessageService serviceMail = context.getBean(MailService.class);
        serviceMail.sendMessage(message);

        MessageService serviceSms = context.getBean(SmsService.class);
        serviceSms.sendMessage(message);

        MessageService serviceMail1 = context.getBean(MailService.class);
        serviceMail1.sendMessage(message);
        serviceMail1.saveMessage(message);
    }
}
