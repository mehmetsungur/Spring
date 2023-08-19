package com.modulcar.service;

import com.modulcar.domain.Message;
import org.springframework.stereotype.Component;

@Component
public class MailServie implements MessageService {
    @Override
    public void sendMessage(Message message) {
        System.out.println("Mail Service " + message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {

    }
}
