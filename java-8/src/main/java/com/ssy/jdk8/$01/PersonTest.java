package com.ssy.jdk8.$01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by robin on 19/1/14.
 */
public class PersonTest {


    public static void main(String[] args) {
        PersonTest test = new PersonTest();
        Person person3 = new Person("张三", 23);
        Person person4 = new Person("李四", 24);
        Person person5 = new Person("王五", 25);
        Person person6 = new Person("赵六", 26);

        List<Person> personList = Arrays.asList(person3, person4, person5, person6);
        final List<Person> personsByName = test.getPersonsByName("张三", personList);
        System.out.println(personsByName);
    }


    public List<Person> getPersonsByName(String name, List<Person> persons) {
        return persons.stream().filter(person -> person.getUsername().equals(name)).collect(Collectors.toList());
    }

}
