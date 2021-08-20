package com.openlab.service;

import com.openlab.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> getUserList();
    public void createUser(User user);
    public User getUserById(Long id);
    public void updateUser(Long id,User user);
    public void delteById(Long id);
}
