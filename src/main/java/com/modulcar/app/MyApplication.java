package com.modulcar.app;

import com.modulcar.AppConfiguration;
import com.modulcar.domain.Message;
import com.modulcar.service.MailService;
import com.modulcar.service.MessageService;
import com.modulcar.service.SmsService;
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
    }
}
