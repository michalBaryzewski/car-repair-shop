package com.cwm.carworkshop.controller;

import com.cwm.carworkshop.model.User;
import com.cwm.carworkshop.service.CurrentUser;
import com.cwm.carworkshop.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import java.util.logging.*;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/admin")
//    @ResponseBody
//    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
//        User entityUser = customUser.getUser();
//        return "Hello " + entityUser.getUsername();
//    }

//    @GetMapping("/create-user")
//    @ResponseBody
//    public String createUser() {
//        User user = new User();
//        user.setUsername("admin");
//        user.setPassword("admin");
//        userService.saveUser(user);
//        return "utworzono admina";
//    }


}
