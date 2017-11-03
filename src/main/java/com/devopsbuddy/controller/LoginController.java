package com.devopsbuddy.controller;

import com.devopsbuddy.backend.service.EmailService;
import com.devopsbuddy.web.domain.frontend.FeedbackPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    public static final String LOGIN_VIEW_NAME = "user/login";


    @RequestMapping("/login")
    public String login() {

        return LoginController.LOGIN_VIEW_NAME;
    }
}
