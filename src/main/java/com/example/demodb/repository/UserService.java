package com.example.demodb.repository;

import com.example.demodb.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Eduard Ivanov on 7/1/21
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public long save(User user) {
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    public String getName(long id) {
        userRepository.flush();
        return userRepository.getUserName(id);
    }
}
