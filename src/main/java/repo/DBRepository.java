package repo;

import domain.Message;

public class DBRepository implements Repository{
    @Override
    public void save(Message message) {
        System.out.println("Mesajınız DB kaydedildi " + message.getMessage());
    }
}
