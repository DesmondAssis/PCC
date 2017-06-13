package com.desmond;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Li.Xiaochuan on 17/6/1.
 */
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/main-servlet.xml")
public class BaseTest {
    @Autowired
    protected WebApplicationContext wac;
}
