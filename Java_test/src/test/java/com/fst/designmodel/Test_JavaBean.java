package com.fst.designmodel;

public class Test_JavaBean {
    private int id;
    private int age;
    private String name;

    public Test_JavaBean(int id, int age, String name, String address) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.address = address;
    }

    private String address;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
