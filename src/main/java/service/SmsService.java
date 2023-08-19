package service;

import domain.Message;

public class SmsService implements MessageService {
    public void sendMessage(Message message){
        System.out.println("Ben bir Smsservisiyim " + message.getMessage());
    }
}
