package com.desmond.service;

import com.desmond.BaseTest;
import com.desmond.model.User;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Li.Xiaochuan on 17/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest extends BaseTest{

    @Autowired
    private UserService userService;

    @Test
    public void add() throws Exception {
        User user = new User();
        user.setName("Desmond");

        userService.add(user);

        Assert.assertTrue(true);
    }

    @Test
    public void findByName() throws Exception {
        String name = "'%mond%'";

        PageBounds pageBounds = new PageBounds();
        pageBounds.setLimit(2);
        pageBounds.setPage(1);

        List<User> userList = userService.findByName(name, pageBounds);

        pageBounds.setPage(2);

        userList = userService.findByName(name, pageBounds);

        Assert.assertTrue(true);
    }
}