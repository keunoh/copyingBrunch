package com.brunch.kaltz.builder;

import lombok.Getter;

@Getter
public class Student {
    private int id;
    private String name = "random";
    private String grade = "freshman";
    private String phoneNumber = "010-0000-0000";

    public Student(int id, String name, String grade, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
