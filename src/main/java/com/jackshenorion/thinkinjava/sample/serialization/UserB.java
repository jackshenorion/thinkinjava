package com.jackshenorion.thinkinjava.sample.serialization;

import java.io.*;

public class UserB implements Externalizable {

    private String name;
    private int age;

    public UserB() {
        System.out.println("Constructor without parameters");
    }

    public UserB(String name, int age) {
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
    }
}
