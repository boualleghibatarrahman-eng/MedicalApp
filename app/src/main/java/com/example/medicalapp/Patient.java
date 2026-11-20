package com.example.medicalapp;

public class Patient {
    private String firstName, lastName, email, phone, sex;
    private int age;

    public Patient(String firstName, String lastName, String email, String phone, int age, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.sex = sex;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getSex() { return sex; }
}