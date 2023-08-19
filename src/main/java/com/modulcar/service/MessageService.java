package com.modulcar.service;

import com.modulcar.domain.Message;

public interface MessageService {
    void sendMessage(Message message);
    void saveMessage(Message message);
}
