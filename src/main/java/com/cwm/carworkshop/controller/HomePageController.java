package com.cwm.carworkshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomePageController {

    @GetMapping("/")
    @ResponseBody
    public String home() { return "Here you can find some details for unlogged users"; }

    @GetMapping("/about")
    public String about() { return "index"; }

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
