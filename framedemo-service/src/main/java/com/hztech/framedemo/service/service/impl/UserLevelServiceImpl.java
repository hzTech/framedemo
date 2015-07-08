package com.hztech.framedemo.service.service.impl;

import com.hztech.framedemo.service.bean.UserLevelBean;
import com.hztech.framedemo.service.repositories.UserLevelRepository;
import com.hztech.framedemo.service.service.UserLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by allan on 2015/7/8.
 */
@Service
public class UserLevelServiceImpl implements UserLevelService {
    @Autowired
    private UserLevelRepository levelRepository;

    @Transactional
    public UserLevelBean save(UserLevelBean levelBean) {
        return levelRepository.save(levelBean);
    }

    @Transactional(readOnly = true)
    public List<UserLevelBean> findAll() {
        return levelRepository.findAll();
    }
}
