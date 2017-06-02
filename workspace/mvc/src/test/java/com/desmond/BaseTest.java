package com.desmond;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Li.Xiaochuan on 17/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/main-servlet.xml")
public class BaseTest {

    public void simple() throws Exception {

    }
}
