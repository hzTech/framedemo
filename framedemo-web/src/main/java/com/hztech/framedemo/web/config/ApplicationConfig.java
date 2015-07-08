package com.hztech.framedemo.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Administrator on 2015/5/18.
 */
@Configuration
@ComponentScan(basePackages = "com.hztech.framedemo.web")
@ImportResource({"classpath*:applicationContext-datacenter.xml", "classpath*:produconfig.xml"})
public class ApplicationConfig {
}
