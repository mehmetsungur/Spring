package com.modulcar.service;

import com.modulcar.domain.Message;
import com.modulcar.repo.DBRepository;
import com.modulcar.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MailService implements MessageService {
    @Autowired
    @Qualifier("FileRepository")
    private Repository repository;

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
