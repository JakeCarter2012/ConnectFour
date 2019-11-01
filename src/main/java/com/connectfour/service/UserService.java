package com.connectfour.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.connectfour.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository UserRepo;
}
