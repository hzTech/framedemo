package com.hztech.framedemo.web.controller.api;

import com.hztech.framedemo.web.config.ApplicationConfig;
import com.hztech.framedemo.web.config.WebConfig;
import com.hztech.framedemo.web.controller.SpringTestBase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by allan on 2015/7/8.
 */
@ActiveProfiles("test")
@ContextConfiguration(classes = {WebConfig.class, ApplicationConfig.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserApiControllerTest extends SpringTestBase {

    /**
     * 模拟cookie
     */
    private Cookie mockCookie;

    @Before
    public void setUp() throws Exception {
        mockCookie = new Cookie("xxx", "xxx");
        mockCookie.setPath("/");
        mockCookie.setMaxAge(123123);
    }

    @Test
    public void testSave() throws Exception {
        //模拟一个springmvc请求
        mockMvc.perform(post("/userApi/save")
                .param("firstName", "mockFirstName")
                .param("lastName", "mockLastName")
                .cookie(mockCookie))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.resultCode").value(1));
    }
}