package com.mapper.usermapper;

import com.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int setUser(User user);
    User getUser(User user);
    String getUserPassword();
    Integer addUser(User user);
    User getUserNameAndPassword(User user);
}
