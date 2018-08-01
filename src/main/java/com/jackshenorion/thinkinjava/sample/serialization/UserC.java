package com.jackshenorion.thinkinjava.sample.serialization;

import java.io.*;

public class UserC implements Serializable {

    private String name;
    private int age;

    public UserC() {
        System.out.println("Constructor without parameters");
    }

    public UserC(String name, int age) {
        System.out.println("Constructor with parameters");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("writeObject");
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("readObject");
        in.defaultReadObject();
        age = age + 1;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
