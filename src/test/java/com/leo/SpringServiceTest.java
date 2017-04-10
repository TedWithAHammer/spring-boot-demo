package com.leo;

import com.leo.service.DataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.swing.*;

/**
 * Created by wangliying on 2017/4/10.
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringServiceTest {

    @Autowired
    private DataService service;

    @Test
    public void testInterface() {

    }
}
