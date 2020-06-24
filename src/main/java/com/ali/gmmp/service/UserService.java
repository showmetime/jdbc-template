package com.ali.gmmp.service;

import com.ali.gmmp.entity.User;

import java.util.List;

public interface UserService {
    int insert(User user);
    int update(User user);
    int delete(User user);
    List<User> findAll();
    void updateALL(List<User> users);
}
