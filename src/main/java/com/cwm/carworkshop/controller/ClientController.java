package com.cwm.carworkshop.controller;

import com.cwm.carworkshop.model.Car;
import com.cwm.carworkshop.model.User;
import com.cwm.carworkshop.repository.CarRepository;
import com.cwm.carworkshop.repository.TaskRepository;
import com.cwm.carworkshop.service.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {

    private final TaskRepository taskRepository;
    private final CarRepository carRepository;

    public ClientController(TaskRepository taskRepository, CarRepository carRepository) {
        this.taskRepository = taskRepository;
        this.carRepository = carRepository;
    }

    @GetMapping("")
    public String homePanel() {
        return "client/clientPanel";
    }

    @GetMapping("/create-car")
    public String createCar(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "createCar";
    }



}
