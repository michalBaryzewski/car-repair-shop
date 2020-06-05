package com.cwm.carworkshop.controller;

import com.cwm.carworkshop.model.Role;
import com.cwm.carworkshop.model.User;
import com.cwm.carworkshop.repository.RoleRepository;
import com.cwm.carworkshop.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class HomePageController {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public HomePageController(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/about")
    @ResponseBody
    public String about() {
//        Role role = roleRepository.findByName("ROLE_ADMIN");
        Set<Role> roles = roleRepository.findAllByName("ROLE_ADMIN");
        List<User> users = userRepository.findAllByRolesIn(roles);
        return users.toString();
    }

    @GetMapping("/admin/home")
    @ResponseBody
    public String adminHome() {
        return "ADMIN PANEL";
    }

    @GetMapping("/manager/home")
    @ResponseBody
    public String managerHome() {
        return "MANAGER PANEL";
    }

    @GetMapping("/employee/home")
    @ResponseBody
    public String employeeHome() {
        return "EMPLOYEE PANEL";
    }

    @GetMapping("/client/home")
    @ResponseBody
    public String clientHome() {
        return "CLIENT PANEL";
    }


}
