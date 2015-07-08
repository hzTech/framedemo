package com.hztech.framedemo.service.service;

import com.hztech.framedemo.service.bean.UserLevelBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by allan on 2015/7/8.
 */
public interface UserLevelService {
    /**
     * 保存更新用户等级
     *
     * @param levelBean
     * @return
     */
    @Transactional
    UserLevelBean save(UserLevelBean levelBean);

    /**
     * 得到用户等级列表
     *
     * @return
     */
    @Transactional
    List<UserLevelBean> findAll();
}
