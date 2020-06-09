package com.cwm.carworkshop.controller;

import com.cwm.carworkshop.model.*;
import com.cwm.carworkshop.repository.*;
import com.cwm.carworkshop.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
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
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Value("classpath:static/carBrands.txt")
    private Resource resourceCarBrands;

    @Value("classpath:static/countries.txt")
    private Resource resourceCountries;

    public AdminController(UserRepository userRepository, RoleRepository roleRepository, UserService userService, TaskStatusRepository taskStatusRepository, CarRepository carRepository, TaskRepository taskRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userService = userService;
        this.taskStatusRepository = taskStatusRepository;
        this.carRepository = carRepository;
        this.taskRepository = taskRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("")
    public String homePanel() {
        return "admin/adminPanel";
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "admin/createUser";
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public String createUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/delete-user/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable long id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(Exception::new);
        userRepository.delete(user);
        return "redirect:/admin";
    }

    @GetMapping("/update-user/{id}")
    public String updateUser(@PathVariable long id, Model model) throws Exception {
        User user = userRepository.findById(id).orElseThrow(Exception::new);
        model.addAttribute("user", user);
        return "admin/userEdit";
    }

    @PostMapping("/update-user/{id}")
    public String updateUser(@ModelAttribute User user, @PathVariable long id) throws Exception {
        User user1 = userRepository.findById(id).orElseThrow(Exception::new);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setUsername(user.getUsername());
        user1.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user1.setRoles(user.getRoles());
        user1.setEnabled(user.getEnabled());
        userRepository.save(user1);
        return "redirect:/admin";
    }

    @GetMapping("/create-car")
    public String createCar(Model model) {
        model.addAttribute("car", new Car());
        return "admin/createCar";
    }

    @PostMapping("/create-car")
    public String createCar(@ModelAttribute Car car) {
        carRepository.save(car);
        return "redirect:/admin";
    }

    @GetMapping("/delete-car/{id}")
    public String deleteCar(@PathVariable long id) throws Exception {
        Car car = carRepository.findById(id).orElseThrow(Exception::new);
        carRepository.delete(car);
        return "redirect:/admin";
    }

    @GetMapping("/update-car/{id}")
    public String updateCar(Model model, @PathVariable long id) throws Exception {
        Car car = carRepository.findById(id).orElseThrow(Exception::new);
        model.addAttribute("car", car);
        return "admin/carEdit";
    }

    @PostMapping("/update-car/{id}")
    public String updateCar(@ModelAttribute Car car, @PathVariable long id) throws Exception {
        Car car1 = carRepository.findById(id).orElseThrow(Exception::new);
        car1.setBrand(car.getBrand());
        car1.setModel(car.getModel());
        car1.setLicensePlate(car.getLicensePlate());
        car1.setYearOfProduction(car.getYearOfProduction());
        car1.setCountryOfOrigin(car.getCountryOfOrigin());
        car1.setEngine(car.getEngine());
        car1.setPower(car.getPower());
        car1.setFuelType(car.getFuelType());
        car1.setGearboxType(car.getGearboxType());
        car1.setMileage(car.getMileage());
        car1.setOwner(car.getOwner());
        carRepository.save(car1);
        return "redirect:/admin";
    }

    @GetMapping("/create-task")
    public String createTask(Model model) {
        model.addAttribute("task", new Task());
        return "admin/createTask";
    }

    @PostMapping("/create-task")
    public String createTask(@ModelAttribute Task task) {
        task.setCreated(LocalDateTime.now());
        taskRepository.save(task);
        return "redirect:/admin";
    }

    @GetMapping("/update-task/{id}")
    public String updateTask(Model model, @PathVariable long id) throws Exception {
        Task task = taskRepository.findById(id).orElseThrow(Exception::new);
        model.addAttribute("task", task);
        return "admin/taskEdit";
    }

    @PostMapping("/update-task/{id}")
    public String updateTask(@ModelAttribute Task task, @PathVariable long id) throws Exception {
        Task task1 = taskRepository.findById(id).orElseThrow(Exception::new);
        task1.setDescription(task.getDescription());
        task1.setClients(task.getClients());
        task1.setEmployees(task.getEmployees());
        task1.setCar(task.getCar());
        task1.setUpdated(LocalDateTime.now());
        taskRepository.save(task1);
        return "redirect:/admin";
    }

    @GetMapping("/cars")
    public String cars() {
        return "admin/carList";
    }

    @GetMapping("/users")
    public String users() { return "admin/userList"; }

    @GetMapping("/tasks")
    public String tasks() { return "admin/taskList"; }

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

    @ModelAttribute("tasks")
    private List<Task> taskList() {
        return taskRepository.findAll();
    }

    @ModelAttribute("cars")
    private List<Car> carList() {
        return carRepository.findAll();
    }

    @ModelAttribute("carTypes")
    private List<String> carTypes() throws IOException {
        List<String> list = new ArrayList<>();

        Scanner scanner = new Scanner(resourceCarBrands.getFile());
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        return list;
    }

    @ModelAttribute("countries")
    private List<String> countries() throws IOException {
        List<String> list = new ArrayList<>();

        Scanner scanner = new Scanner(resourceCountries.getFile());
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        return list;
    }

    @ModelAttribute("gearboxTypes")
    private List<String> gearboxTypes() {
        return Arrays.asList("manual", "automatic");
    }
}




