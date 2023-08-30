package com.modulcar.repository;

import java.util.Optional;
import com.modulcar.domain.User;
import com.modulcar.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName) throws ResourceNotFoundException;
}
