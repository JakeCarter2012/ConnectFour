package com.connectfour.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.connectfour.repository.FriendRepositoryImpl;

@Service("friendService")
public class FriendServiceImpl implements FriendService{
    @Autowired
    FriendRepositoryImpl FriendRepo;
}
