package com.desmond.service;

import com.desmond.repository.UserMapper;
import com.desmond.model.User;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Li.Xiaochuan on 17/6/1.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int add(User user) {
        return userMapper.insertSelective(user);
    }

    // https://github.com/miemiedev/mybatis-paginator
    public List<User> findByName(String name, PageBounds pageBounds) {
        return userMapper.findbyName(name, pageBounds);
    }
}
