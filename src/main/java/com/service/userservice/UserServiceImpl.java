package com.service.userservice;

import com.mapper.usermapper.UserMapper;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User getUser(User user) {

        return userMapper.getUser(user);
    }

    @Override
    public Integer addUser(User user) {

        return userMapper.addUser(user);
    }

    @Override
    public Integer deleteUser(User user) {

        return userMapper.addUser(user);
    }

    @Override
    public Integer modifyUser(User user) {
        return null;
    }

    @Override
    public boolean getUserNameAndPassword(User user) {
        if(userMapper.getUserNameAndPassword(user)==null){
            return true;
        }else{
            return false;
        }

    }


}
