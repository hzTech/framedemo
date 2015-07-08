package com.hztech.framedemo.service.service;

import com.hztech.framedemo.service.TestBase;
import com.hztech.framedemo.service.bean.UserBean;
import com.hztech.framedemo.service.bean.UserLevelBean;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by allan on 2015/7/8.
 */
@ActiveProfiles("test")
@ContextConfiguration(locations = {"/applicationContext-datacenter.xml", "/produconfig.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserServiceTest extends TestBase {
    @Autowired
    private UserService userService;
    @Autowired
    private UserLevelService levelService;

    private UserBean mockUser;
    private UserLevelBean mockLevel;

    @Before
    public void setUp() throws Exception {
        mockLevel = new UserLevelBean();
        mockLevel.setLevelName("mockLevel");
        mockLevel = levelService.save(mockLevel);

        mockUser = new UserBean();
        mockUser.setFirstName("mockFirstName");
        mockUser.setLastName("mockLastName");
        mockUser.setAge(18);
        mockUser.setUserLevel(mockLevel);
        mockUser = userService.save(mockUser);
    }

    @Test
    public void testSave() throws Exception {
        UserBean testUser = new UserBean();
        testUser.setFirstName("testName");
        testUser.setUserLevel(mockLevel);
        UserBean addedUser = userService.save(testUser);
        assertEquals(mockLevel.getLevelId(), addedUser.getUserLevel().getLevelId());
        assertEquals(testUser.getFirstName(), addedUser.getFirstName());
    }

    @Test
    public void testFindAll() throws Exception {
        Page<UserBean> pageInfo = userService.findAll(1, 20);
        assertEquals(1, pageInfo.getTotalElements());
        assertEquals(mockUser.getId(), pageInfo.getContent().get(0).getId());
    }

    @Test
    public void testFindById() throws Exception {
        UserBean userBean = userService.findById(mockUser.getId());
        assertNotNull(userBean);
        assertEquals(mockUser.getId(), userBean.getId());
    }

    @Test
    @Ignore
    public void testFindByFirstName() throws Exception {

    }

    @Test
    public void testUpdateFirstName() throws Exception {
        String toUpdate = "toUpdate";
        userService.updateFirstName(toUpdate, mockUser.getId());
        //删除一级二级缓存
        entityManager.clear();
        managerFactory.getCache().evictAll();
        //删除以后查询得到的实体才是修改过的实体
        UserBean userBean = userService.findById(mockUser.getId());
        assertEquals(toUpdate, userBean.getFirstName());
    }
}