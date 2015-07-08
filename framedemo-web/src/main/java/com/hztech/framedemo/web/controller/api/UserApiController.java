package com.hztech.framedemo.web.controller.api;

import com.hztech.framedemo.service.bean.UserBean;
import com.hztech.framedemo.web.bean.ApiResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by allan on 2015/7/8.
 */
public interface UserApiController {
    /**
     * 保存更新用户信息
     *
     * @param userBean
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    ApiResult<UserBean> save(UserBean userBean);
}
