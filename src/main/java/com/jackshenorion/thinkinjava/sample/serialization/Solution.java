package com.jackshenorion.thinkinjava.sample.serialization;

import com.jackshenorion.thinkinjava.sample.annotation.TimeTrace;

import java.io.*;

public class Solution {

    @TimeTrace(value = "main")
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        testSerializableWithWriteAndReadObject();
    }

    private static void testObjectSerialization() throws IOException, ClassNotFoundException {
        User user1 = new User("Jack", 10, "password");
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("./user.sr")));
        os.writeObject(user1);
        os.close();

        ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("./user.sr")));
        User userNew = (User) is.readObject();
        System.out.println(userNew);
    }

    private static void testObjectExternalizable() throws IOException, ClassNotFoundException {
        System.out.println("Write object");
        UserB user = new UserB("Jack", 10);
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("./user_b.sr")));
        os.writeObject(user);
        os.close();

        System.out.println("Read object");
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("./user_b.sr")));
        UserB userNew = (UserB) is.readObject();
        System.out.println(userNew);
    }

    @TimeTrace(value = "testSerializableWithWriteAndReadObject")
    private static void testSerializableWithWriteAndReadObject() throws IOException, ClassNotFoundException {
        System.out.println("Write object");
        UserC user = new UserC("Jack", 10);
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("./user_c.sr")));
        os.writeObject(user);
        os.close();

        System.out.println("Read object");
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("./user_c.sr")));
        UserC userNew = (UserC) is.readObject();
        System.out.println(userNew);
    }

    private static void testEmbeddedObject() {

    }

    private static void testSharedObjectRef() {

    }
}
