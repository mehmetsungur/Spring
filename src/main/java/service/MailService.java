package service;

import domain.Message;

public class MailService implements MessageService{
    public void sendMessage(Message message){
        System.out.println("Ben bir MailServisiyim " + message.getMessage());
    }
}
