package com.cwm.carworkshop.controller;

import com.cwm.carworkshop.model.*;
import com.cwm.carworkshop.repository.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private final CarRepository carRepository;
    private final TaskRepository taskRepository;
    private final TaskStatusRepository taskStatusRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public ManagerController(CarRepository carRepository, TaskRepository taskRepository, TaskStatusRepository taskStatusRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.taskRepository = taskRepository;
        this.taskStatusRepository = taskStatusRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Value("classpath:static/carBrands.txt")
    private Resource resourceCarBrands;

    @Value("classpath:static/countries.txt")
    private Resource resourceCountries;


    @GetMapping("")
    public String homePanel() {
        return "manager/managerPanel";
    }

    @GetMapping("/create-car")
    public String createCar(Model model) {
        model.addAttribute("car", new Car());
        return "manager/createCar";
    }

    @PostMapping("/create-car")
    public String createCar(@ModelAttribute Car car) {
        carRepository.save(car);
        return "redirect:/manager";
    }

    @DeleteMapping("/delete-car/{id}")
    public String deleteCar(@PathVariable long id) throws Exception {
        Car car = carRepository.findById(id).orElseThrow(Exception::new);
        carRepository.delete(car);
        return "redirect:/manager";
    }

    @GetMapping("/update-car/{id}")
    public String updateCar(Model model, @PathVariable long id) throws Exception {
        Car car = carRepository.findById(id).orElseThrow(Exception::new);
        model.addAttribute("car", car);
        return "manager/carEdit";
    }

    @PutMapping("/update-car/{id}")
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
        return "redirect:/manager";
    }

    @GetMapping("/create-task")
    public String createTask(Model model) {
        model.addAttribute("task", new Task());
        return "manager/createTask";
    }

    @PostMapping("/create-task")
    public String createTask(@ModelAttribute Task task) {
        task.setCreated(LocalDateTime.now());
        taskRepository.save(task);
        return "redirect:/manager";
    }

    @GetMapping("/update-task/{id}")
    public String updateTask(Model model, @PathVariable long id) throws Exception {
        Task task = taskRepository.findById(id).orElseThrow(Exception::new);
        model.addAttribute("task", task);
        return "employee/taskEdit";
    }

    @PutMapping("/update-task/{id}")
    public String updateTask(@ModelAttribute Task task, @PathVariable long id) throws Exception {
        Task task1 = taskRepository.findById(id).orElseThrow(Exception::new);
        task1.setDescription(task.getDescription());
        task1.setClients(task.getClients());
        task1.setEmployees(task.getEmployees());
        task1.setCar(task.getCar());
        task1.setUpdated(LocalDateTime.now());
        taskRepository.save(task1);
        return "redirect:/manager";
    }

    @GetMapping("/cars")
    public String cars() {
        return "manager/carList";
    }

    @GetMapping("/tasks")
    public String tasks() { return "employee/taskList"; }

    @ModelAttribute("statuses")
    private List<TaskStatus> taskStatusList() {
        return taskStatusRepository.findAll();
    }

    @ModelAttribute("tasks")
    private List<Task> taskList() {
        return taskRepository.findAll();
    }

    @ModelAttribute("cars")
    private List<Car> carList() {
        return carRepository.findAll();
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
