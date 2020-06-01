package com.cwm.carworkshop.model;

import javax.persistence.*;

@Entity
@Table(name = "statuses")
public class TaskStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
