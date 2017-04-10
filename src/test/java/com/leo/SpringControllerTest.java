package com.leo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by wangliying on 2017/4/10.
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testMvc() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/findAll"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

}
