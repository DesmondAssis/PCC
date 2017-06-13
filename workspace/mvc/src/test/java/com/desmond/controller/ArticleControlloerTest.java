package com.desmond.controller;

import com.desmond.BaseTest;
import com.desmond.util.MediaType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by presleyli on 2017/6/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ArticleControlloerTest extends BaseTest{
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(wac).build();
    }

    @Test
    public void dolike() throws Exception {
        this.mockMvc
                .perform(get("/server_ip/pcc?action=like&oid=1&uid=1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.error_code").value("501"));
    }

    @Test
    public void isLike() throws Exception {
        this.mockMvc
                .perform(get("/server_ip/pcc?action=is_like&oid=1&uid=2").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getCountResult() throws Exception {
        this.mockMvc
                .perform(get("/server_ip/pcc?action=count&oid=1&uid=2").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getLikeList() throws Exception {
        this.mockMvc
                .perform(get("/server_ip/pcc?action=list&cursor=0&page_size=5&is_friend=1&oid=1&uid=3").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
