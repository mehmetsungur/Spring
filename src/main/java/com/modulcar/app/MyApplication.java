package com.modulcar.app;

import com.modulcar.AppConfiguration;
import com.modulcar.domain.Message;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MyApplication {
    public static void main(String[] args) {
        Message message = new Message();
        message.setMessage("Spring ile uygulama geliştirme");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
    }
}
