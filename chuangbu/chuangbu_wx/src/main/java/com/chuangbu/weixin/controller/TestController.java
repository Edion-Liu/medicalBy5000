package com.chuangbu.weixin.controller;

import com.chuangbu.weixin.shiro.service.UsernamePasswordCaptchaToken;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/mytest/")
public class TestController {
    @RequestMapping(value = "/test")
    public ModelAndView login(HttpServletRequest request, String userName, String password, String captcha,
                              HttpServletResponse response, Model model) {

        return new ModelAndView("test");
    }
}
