package com.jackshenorion.thinkinjava.sample.serialization;

import jersey.repackaged.com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

public class Company implements Serializable {
    private String name;
    private List<User> employees = Lists.newArrayList();

    public Company(String name, List<User> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public List<User> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
