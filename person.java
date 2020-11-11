package com.codebind;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class person {
    private String name;
    private String id;
    private String city;
    private int salary;
    private LocalDate joinedDate;


    public person(String name, String id, String city, int salary, LocalDate joinedDate) {
        this.name = name;
        this.id = id;
        this.city = city;
        this.salary = salary;
        this.joinedDate = joinedDate;
    }
    public person(String name, String id, String city, int salary, String joinedDate) {
        this.name = name;
        this.id = id;
        this.city = city;
        this.salary = salary;
        this.setJoinedDate(joinedDate);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }
    public void setJoinedDate(String joinedDate){
        this.joinedDate=LocalDate.parse(joinedDate, DateTimeFormatter.ofPattern("dd-mm-yyyy"));
    }
}
