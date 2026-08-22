package com.dlflix.service;

import com.dlflix.entity.User;
import com.dlflix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }
}
