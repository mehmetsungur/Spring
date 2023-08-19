package service;

import domain.Message;
import org.springframework.stereotype.Component;
import repo.DBRepository;
import repo.Repository;

@Component
public class MailService implements MessageService{
    private Repository repository;

    public MailService(Repository repository) {
        this.repository = repository;
    }

    public void sendMessage(Message message){
        System.out.println("Ben bir MailServisiyim " + message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        //mesajı kaydetmek için repo objesi
        //Repository repository = new DBRepository();
        repository.save(message);
    }
}
