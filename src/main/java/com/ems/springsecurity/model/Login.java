package com.ems.springsecurity.model;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {
    @Id
    @Column(name = "user_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    @MapsId
    private Employee employee;

    @Column(name = "password")
    private String password;

    public Login() {
    }

    public Login(int id, Employee employee, String password) {
        this.id = id;
        this.employee = employee;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
