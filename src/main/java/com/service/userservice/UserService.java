package com.service.userservice;

import com.pojo.User;

import java.util.List;

public interface UserService {
    /**
     *
     * @param user
     * @return
     */
    public User getUser(User user);

    public Integer addUser(User user);

    public Integer deleteUser(User user);

    public Integer modifyUser(User user);

    public boolean getUserNameAndPassword(User user);
}
