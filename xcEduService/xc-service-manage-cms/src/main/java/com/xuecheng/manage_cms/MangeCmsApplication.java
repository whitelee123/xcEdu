package com.xuecheng.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author jojo
 * @date 2019/11/18 22:06
 **/
@SpringBootApplication
@ComponentScan(basePackages={"com.xuecheng.api"})//扫描接口
@EntityScan("com.xuecheng.framework.domain.cms")//扫描实体类
@ComponentScan(basePackages={"com.xuecheng.framework"})//扫描接口
@ComponentScan(basePackages={"com.xuecheng.manage_cms"})//扫描本项目下的所有类
public class MangeCmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MangeCmsApplication.class,args);
    }
}
