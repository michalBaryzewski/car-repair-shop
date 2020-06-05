package com.cwm.carworkshop.controller;

import com.cwm.carworkshop.model.*;
import com.cwm.carworkshop.repository.*;
import com.cwm.carworkshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserService userService;
    private final TaskStatusRepository taskStatusRepository;
    private final CarRepository carRepository;
    private final TaskRepository taskRepository;

    public AdminController(UserRepository userRepository, RoleRepository roleRepository, UserService userService, TaskStatusRepository taskStatusRepository, CarRepository carRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.taskStatusRepository = taskStatusRepository;
        this.carRepository = carRepository;
        this.taskRepository = taskRepository;
    }

    @GetMapping("")
    public String homePanel() {
        return "adminPanel";
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public String createUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/delete-user/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(Exception::new);
        userRepository.delete(user);
        return "redirect:/admin";
    }

    @GetMapping("/create-car")
    public String createCar(Model model) {
        model.addAttribute("car", new Car());
        return "createCar";
    }

    @PostMapping("/create-car")
    public String createCar(@ModelAttribute Car car) {
        carRepository.save(car);
        return "redirect:/admin";
    }

    @GetMapping("/create-task")
    public String createTask(Model model) {
        model.addAttribute("task", new Task());
        return "createTask";
    }

    @PostMapping("/create-task")
    public String createTask(@ModelAttribute Task task) {
        task.setCreated(LocalDateTime.now());
        taskRepository.save(task);
        return "redirect:/admin";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return roleRepository.findByName("ROLE_CLIENT").toString();
    }


    @ModelAttribute("roles")
    private List<Role> roleList() {
        return roleRepository.findAll();
    }

    @ModelAttribute("statuses")
    private List<TaskStatus> taskStatusList() {
        return taskStatusRepository.findAll();
    }

    @ModelAttribute("users")
    private List<User> userList() {
        return userRepository.findAll();
    }

    @ModelAttribute("clients")
    private List<User> clientList() throws Exception {
        Set<Role> roles = roleRepository.findAllByName("ROLE_CLIENT");
        return userRepository.findAllByRolesIn(roles);
    }

    @ModelAttribute("employees")
    private List<User> employeeList() throws Exception {
        Set<Role> roles = roleRepository.findAllByName("ROLE_EMPLOYEE");
        return userRepository.findAllByRolesIn(roles);
    }

    @ModelAttribute("cars")
    private List<Car> carList() {
        return carRepository.findAll();
    }
}




