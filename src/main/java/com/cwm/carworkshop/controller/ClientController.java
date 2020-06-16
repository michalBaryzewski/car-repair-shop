package com.cwm.carworkshop.controller;

import com.cwm.carworkshop.model.Car;
import com.cwm.carworkshop.model.Task;
import com.cwm.carworkshop.model.TaskStatus;
import com.cwm.carworkshop.model.User;
import com.cwm.carworkshop.repository.CarRepository;
import com.cwm.carworkshop.repository.TaskRepository;
import com.cwm.carworkshop.repository.TaskStatusRepository;
import com.cwm.carworkshop.service.CurrentUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping("/client")
public class ClientController {

    private final TaskRepository taskRepository;
    private final CarRepository carRepository;
    private final TaskStatusRepository taskStatusRepository;

    @Value("classpath:static/carBrands.txt")
    private Resource resourceCarBrands;

    @Value("classpath:static/countries.txt")
    private Resource resourceCountries;

    public ClientController(TaskRepository taskRepository, CarRepository carRepository, TaskStatusRepository taskStatusRepository) {
        this.taskRepository = taskRepository;
        this.carRepository = carRepository;
        this.taskStatusRepository = taskStatusRepository;
    }

    @GetMapping("")
    public String homePanel() {
        return "client/clientPanel";
    }

    @GetMapping("/create-car")
    public String createCar(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "client/createCar";
    }

    @PostMapping("/create-car")
    public String createCar(@ModelAttribute Car car, @AuthenticationPrincipal CurrentUser currentUser) {
        User user = currentUser.getUser();
        car.setOwner(user);
        carRepository.save(car);
        return "redirect:/client";
    }

    @DeleteMapping("/delete-car/{id}")
    public String deleteCar(@PathVariable long id) throws Exception {
        Car car = carRepository.findById(id).orElseThrow(Exception::new);
        carRepository.delete(car);
        return "redirect:/client";
    }

    @GetMapping("/update-car/{id}")
    public String updateCar(@PathVariable long id, Model model) throws Exception {
        Car car = carRepository.findById(id).orElseThrow(Exception::new);
        model.addAttribute("car", car);
        return "redirect:/client";
    }

    @PutMapping("/update-car/{id}")
    public String updateCar(@ModelAttribute Car car, @PathVariable long id) throws Exception {
        Car car1 = carRepository.findById(id).orElseThrow(Exception::new);
        car1.setType(car.getType());
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
        carRepository.save(car1);
        return "redirect:/client";
    }

    @GetMapping("/create-task")
    public String createTask(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "client/createTask";
    }

    @PostMapping("/create-task")
    public String createTask(@ModelAttribute Task task, @AuthenticationPrincipal CurrentUser currentUser) throws Exception {
        task.setCreated(LocalDateTime.now());
        List<User> client = Collections.singletonList(currentUser.getUser());
        task.setClients(client);
        List<TaskStatus> statuses = Collections.singletonList(taskStatusRepository.findById(1L).orElseThrow(Exception::new));
        task.setStatuses(statuses);
        taskRepository.save(task);
        return "redirect:/client";
    }

    @GetMapping("/tasks")
    public String tasks() {
        return "client/taskList";
    }

    @GetMapping("/cars")
    public String cars() {
        return "client/carList";
    }

    @ModelAttribute("tasks")
    private List<Task> taskList(@AuthenticationPrincipal CurrentUser currentUser) {
        return taskRepository.findAllByClients(currentUser.getUser());
    }

    @ModelAttribute("cars")
    private List<Car> carList(@AuthenticationPrincipal CurrentUser currentUser) {
        return carRepository.findAllByOwner(currentUser.getUser());
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