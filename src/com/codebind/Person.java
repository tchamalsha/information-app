package com.codebind;

public class Person {
    private String name;
    private String id;
    private String city;
    private String salary;
    private String joinedDate;



    public Person(String name, String id, String city, String salary, String joinedDate) {
        this.name = name;
        this.id = id;
        this.city = city;
        this.salary = salary;
        this.joinedDate = joinedDate;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

}
