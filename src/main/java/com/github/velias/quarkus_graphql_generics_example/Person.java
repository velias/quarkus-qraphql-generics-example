package com.github.velias.quarkus_graphql_generics_example;

import java.util.Date;

public class Person {

    String name;
    String surname;
    Date birthDate;

    public Person(String name, String surname, Date birthDate) {
        super();
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        if (birthDate != null) {
            return Long.valueOf((System.currentTimeMillis() - birthDate.getTime()) / (365 * 24 * 60 * 60 * 1000L)).intValue();
        } else {
            return -1;
        }
    }

}
