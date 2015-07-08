package com.hztech.framedemo.service.repositories;

import com.hztech.framedemo.service.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 用户数据访问接口，jpa会自动实现
 * Created by allan on 2015/7/8.
 */
public interface UserRepository extends JpaRepository<UserBean, Integer> {
    List<UserBean> findByFirstName(String firstName);

    @Modifying
    @Query("update UserBean set firstName=?1 where id=?2")
    void updateFirstName(String firstName, int id);
}
