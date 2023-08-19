package service;

import domain.Message;
import repo.DBRepository;
import repo.FileRepository;
import repo.Repository;

public class SmsService implements MessageService {
    public void sendMessage(Message message){
        System.out.println("Ben bir Smsservisiyim " + message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        //mesajı kaydetmek için repo objesi
        Repository repository = new FileRepository();
        repository.save(message);
    }
}
