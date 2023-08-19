package com.modulcar.repo;

import com.modulcar.domain.Message;
import org.springframework.stereotype.Component;

@Component
public class FileRepository implements Repository{
    @Override
    public void save(Message message) {
        System.out.println("Mesajınız Dosyaya ye kaydediliyor.");
    }
}
