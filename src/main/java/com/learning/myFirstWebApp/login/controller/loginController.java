package com.learning.myFirstWebApp.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {

    private Logger log = LoggerFactory.getLogger(loginController.class);

    @RequestMapping("login")
    public String goToLogInPage(@RequestParam String name, ModelMap model){
        log.info("Request Param is {}", name);
        model.put("name", name);

        return "login";
    }

}
