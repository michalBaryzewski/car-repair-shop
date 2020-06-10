package com.cwm.carworkshop.controller;

import com.cwm.carworkshop.model.Role;
import com.cwm.carworkshop.model.TaskStatus;
import com.cwm.carworkshop.model.User;
import com.cwm.carworkshop.repository.RoleRepository;
import com.cwm.carworkshop.repository.TaskStatusRepository;
import com.cwm.carworkshop.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Controller
public class HomePageController {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final TaskStatusRepository taskStatusRepository;

    public HomePageController(RoleRepository roleRepository, UserRepository userRepository, TaskStatusRepository taskStatusRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.taskStatusRepository = taskStatusRepository;
    }

    @GetMapping("/about")
    @ResponseBody
    public String about() {
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
