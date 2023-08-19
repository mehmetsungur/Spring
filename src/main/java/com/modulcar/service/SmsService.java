package com.modulcar.service;

import com.modulcar.domain.Message;
import com.modulcar.repo.FileRepository;
import com.modulcar.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmsService implements MessageService{
    private Repository repository;

    @Autowired
    public SmsService(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Sms Service " + message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        repository.save(message);
    }
}
