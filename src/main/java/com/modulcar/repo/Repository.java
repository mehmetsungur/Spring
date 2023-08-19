package com.modulcar.repo;

import com.modulcar.domain.Message;

public interface Repository {
    void save(Message message);
}
