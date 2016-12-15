package com.yusw.northstar.web.controller;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yusw on 2016/11/20.
 */

@RestController
@EnableAutoConfiguration
public class JobController {
    @RequestMapping("/getJob")
    @ResponseBody
    String login(String username,String password) {
        return "success,userName="+username+",password="+password;
    }
}
