package com.cwm.carworkshop.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(name = "task_client",
    joinColumns = @JoinColumn(name = "task_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> clients;
    @ManyToMany
    @JoinTable(name = "task_employee",
    joinColumns = @JoinColumn(name = "task_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> employees;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getClients() {
        return clients;
    }

    public void setClients(List<User> clients) {
        this.clients = clients;
    }

    public List<User> getEmployees() {
        return employees;
    }

    public void setEmployees(List<User> employees) {
        this.employees = employees;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", clients=" + clients +
                ", employees=" + employees +
                ", car=" + car +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
