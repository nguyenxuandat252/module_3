package com.example.student_class.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private float point;
    private int classId;

    public Student() {
    }

    public Student(int id, String name, int age, float point, int classId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.point = point;
        this.classId = classId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
