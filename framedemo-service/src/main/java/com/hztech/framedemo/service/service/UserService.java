package com.hztech.framedemo.service.service;

import com.hztech.framedemo.service.bean.UserBean;
import com.hztech.framedemo.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户业务访问接口
 * Created by allan on 2015/7/8.
 */
public interface UserService {
    /**
     * 保存更新用户信息
     *
     * @param userBean
     * @return
     */
    @Transactional
    UserBean save(UserBean userBean);

    /**
     * 分组查询
     *
     * @return
     */
    @Transactional(readOnly = true)
    Page<UserBean> findAll(int pageIndex, int pageSize);

    /**
     * 根据id得到用户实体
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    UserBean findById(int id);

    /**
     * 根据firstname查询得到列表
     *
     * @param firstName
     * @return
     */
    @Transactional(readOnly = true)
    List<UserBean> findByFirstName(String firstName);

    /**
     * 修改用户firstname
     *
     * @param firstName
     * @param id
     */
    @Transactional
    void updateFirstName(String firstName, int id);
}
