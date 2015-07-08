package com.hztech.framedemo.service.repositories;

import com.hztech.framedemo.service.bean.UserLevelBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by allan on 2015/7/8.
 */
public interface UserLevelRepository extends JpaRepository<UserLevelBean, Integer> {
}
