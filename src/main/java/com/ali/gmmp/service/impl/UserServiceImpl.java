package com.ali.gmmp.service.impl;

import com.ali.gmmp.dao.StudentDaoImpl;
import com.ali.gmmp.entity.User;
import com.ali.gmmp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ASUS
 * @description: TODO
 * @Date: 22:48 2020/6/24
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private StudentDaoImpl dao;
    public void updateAll(List<User> userList){
        List<User> all = dao.findAll();
        for (User user : all) {
            System.out.println(user.toString());
        }
        dao.update(all);

    }

    @Override
    public int insert(User user) {

        return dao.insert(user);
    }

    @Override
    public int update(User user) {
        return dao.update(user);
    }

    @Override
    public int delete(User user) {
        return 0;
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public void updateALL(List<User> users) {
        dao.update(users);
    }
}
