package com.demo.service;

import com.demo.dao.UserDAO;
import com.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public User getUser(int i){
        return userDAO.selectById(i);
    }
}