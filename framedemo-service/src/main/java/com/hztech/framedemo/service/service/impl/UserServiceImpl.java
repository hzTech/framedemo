package com.hztech.framedemo.service.service.impl;

import com.hztech.framedemo.service.bean.UserBean;
import com.hztech.framedemo.service.repositories.UserRepository;
import com.hztech.framedemo.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户业务逻辑实现类
 * Created by allan on 2015/7/8.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserBean save(UserBean userBean) {
        return userRepository.save(userBean);
    }

    @Transactional(readOnly = true)
    public Page<UserBean> findAll(int pageIndex, int pageSize) {
        return userRepository.findAll(new PageRequest(pageIndex - 1, pageSize, new Sort(Sort.Direction.DESC, "id")));
    }

    @Transactional(readOnly = true)
    public UserBean findById(int id) {
        return userRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<UserBean> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    @Transactional
    public void updateFirstName(String firstName, int id) {
        userRepository.updateFirstName(firstName, id);
    }
}
