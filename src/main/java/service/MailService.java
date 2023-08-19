package service;

import domain.Message;
import repo.DBRepository;
import repo.Repository;

public class MailService implements MessageService{
    public void sendMessage(Message message){
        System.out.println("Ben bir MailServisiyim " + message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        //mesajı kaydetmek için repo objesi
        Repository repository = new DBRepository();
        repository.save(message);
    }
}
