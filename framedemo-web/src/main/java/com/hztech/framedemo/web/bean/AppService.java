package com.hztech.framedemo.web.bean;

import com.hztech.framedemo.service.utils.ResourceServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;

/**
 * Created by Administrator on 2015/5/21.
 */
@Service
public class AppService implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ResourceServer uploadResourceServer;
    @Autowired
    private ServletContext servletContext;

    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            servletContext.setAttribute("uploadResourceServer", uploadResourceServer);
        }
    }
}
