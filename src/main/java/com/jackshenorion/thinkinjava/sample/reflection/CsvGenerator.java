package com.jackshenorion.thinkinjava.sample.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;

public class CsvGenerator {

    public static void main(String[] args) {
        Arrays.asList(Item.class.getDeclaredFields()).stream().forEach(f -> getFields("", f));
    }


    private static void getFields(String currentFieldName, Field currentField) {
        if (currentField.getType().isPrimitive()) {
            System.out.println(currentField.getType() + " " + currentFieldName + currentField.getName());
            return;
        }

        if (currentField.getType().isAssignableFrom(String.class)) {
            System.out.println("String" + " " + currentFieldName + currentField.getName());
            return;
        }

        Arrays.asList(currentField.getType().getDeclaredFields()).stream().forEach(sf -> {
            getFields(currentFieldName + currentField.getName() + "_", sf);
        });
    }


}
