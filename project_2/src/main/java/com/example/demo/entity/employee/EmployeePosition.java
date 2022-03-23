package com.example.demo.entity.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class EmployeePosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    @OneToMany(mappedBy = "employeePosition")
    @JsonBackReference
    private List<Employee> employeeList;

    public EmployeePosition() {
    }

    public EmployeePosition(int id, String name, List<Employee> employeeList) {
        this.id = id;
        this.name = name;
        this.employeeList = employeeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
