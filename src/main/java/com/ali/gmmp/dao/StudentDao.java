package com.ali.gmmp.dao;

import com.ali.gmmp.entity.User;

import java.util.List;

public interface StudentDao {
    int insert(User user);
    int update(User user);
    int delete(User user);
    List<User> findAll();
    void update(List<User> users);
}
