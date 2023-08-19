package com.modulcar.service;

import com.modulcar.domain.Message;
import org.springframework.stereotype.Component;

@Component
public class SmsService implements MessageService{
    @Override
    public void sendMessage(Message message) {
        System.out.println("Sms Service " + message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {

    }
}
