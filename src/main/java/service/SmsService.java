package service;

import domain.Message;
import org.springframework.stereotype.Component;
import repo.DBRepository;
import repo.FileRepository;
import repo.Repository;

@Component
public class SmsService implements MessageService {
    private Repository repository;

    public SmsService(Repository repository) {
        this.repository = repository;
    }

    public void sendMessage(Message message){
        System.out.println("Ben bir Smsservisiyim " + message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        //mesajı kaydetmek için repo objesi
        //Repository repository = new FileRepository();
        repository.save(message);
    }
}
