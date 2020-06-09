package com.cwm.carworkshop.controller;

import com.cwm.carworkshop.model.Role;
import com.cwm.carworkshop.model.Task;
import com.cwm.carworkshop.model.TaskStatus;
import com.cwm.carworkshop.model.User;
import com.cwm.carworkshop.repository.RoleRepository;
import com.cwm.carworkshop.repository.TaskRepository;
import com.cwm.carworkshop.repository.TaskStatusRepository;
import com.cwm.carworkshop.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final TaskRepository taskRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final TaskStatusRepository taskStatusRepository;

    public EmployeeController(TaskRepository taskRepository, RoleRepository roleRepository, UserRepository userRepository, TaskStatusRepository taskStatusRepository) {
        this.taskRepository = taskRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.taskStatusRepository = taskStatusRepository;
    }

    @GetMapping("")
    public String homePanel() {
        return "employee/employeePanel";
    }

    @GetMapping("/update-task/{id}")
    public String updateTask(Model model, @PathVariable long id) throws Exception {
        Task task = taskRepository.findById(id).orElseThrow(Exception::new);
        model.addAttribute("task", task);
        return "employee/taskEdit";
    }

    @PostMapping("/update-task/{id}")
    public String updateTask(@ModelAttribute Task task, @PathVariable long id) throws Exception {
        Task task1 = taskRepository.findById(id).orElseThrow(Exception::new);
        task1.setDescription(task.getDescription());
        task1.setStatuses(task.getStatuses());
        task1.setUpdated(LocalDateTime.now());
        taskRepository.save(task1);
        return "redirect:/employee";
    }

    @GetMapping("/tasks")
    public String tasks() { return "employee/taskList"; }

    @ModelAttribute("tasks")
    private List<Task> taskList() {
        return taskRepository.findAll();
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

    @ModelAttribute("statuses")
    private List<TaskStatus> taskStatusList() {
        return taskStatusRepository.findAll();
    }

}
