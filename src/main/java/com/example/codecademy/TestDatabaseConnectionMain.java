package com.example.codecademy;

import com.example.codecademy.Repository.CourseRepository;

public class TestDatabaseConnectionMain {
    public static void main(String[] args) {
        System.out.println("begin database test");
        CourseRepository course = new CourseRepository();

        course.deleteCourse("nederlands");
    }
}
