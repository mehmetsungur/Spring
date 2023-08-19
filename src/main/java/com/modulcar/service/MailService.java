package com.modulcar.service;

import com.modulcar.domain.Message;
import com.modulcar.repo.DBRepository;
import com.modulcar.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailService implements MessageService {
    private Repository repository;

    @Autowired
    public MailService(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mail Service " + message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        repository.save(message);
    }
}
