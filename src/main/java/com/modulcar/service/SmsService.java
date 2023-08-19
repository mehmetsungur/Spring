package com.modulcar.service;

import com.modulcar.domain.Message;
import com.modulcar.repo.FileRepository;
import com.modulcar.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SmsService implements MessageService{
    @Autowired
    @Qualifier("FileRepository")
    private Repository repository;

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
