package com.connectfour.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.connectfour.repository.FriendRepository;

@Service
public class FriendService {
    @Autowired
    FriendRepository FriendRepo;
}
