package com.hztech.framedemo.web.controller.api.impl;

import com.hztech.framedemo.service.bean.UserBean;
import com.hztech.framedemo.service.service.UserService;
import com.hztech.framedemo.web.bean.ApiResult;
import com.hztech.framedemo.web.controller.api.UserApiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by allan on 2015/7/8.
 */
@Controller
public class UserApiControllerImpl implements UserApiController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userApi/save", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult<UserBean> save(UserBean userBean) {
        int result = 0;
        ApiResult<UserBean> apiResult = new ApiResult<UserBean>();
        try {
            userBean.setAddTime(new Date());
            UserBean addedUser = userService.save(userBean);
            apiResult.setMsg("«Î«Û≥…π¶");
            apiResult.setResponseData(addedUser);
            result = 1;
        } catch (Exception e) {
            apiResult.setMsg(e.getMessage());
        }
        apiResult.setResultCode(result);
        return apiResult;
    }
}
