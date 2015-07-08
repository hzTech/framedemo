package com.hztech.framedemo.web.controller;

import com.hztech.framedemo.service.bean.UserBean;
import com.hztech.framedemo.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by allan on 2015/7/8.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static int PAGESIZE = 20;
    @Autowired
    private UserService userService;

    @RequestMapping("/userList")
    public String userList(@RequestParam(value = "pageIndex", required = false, defaultValue = "1") int pageIndex, Model model) {
        Page<UserBean> pageInfo = userService.findAll(pageIndex, PAGESIZE);
        model.addAttribute("pageInfo", pageInfo);
        return "user_list";
    }
}
