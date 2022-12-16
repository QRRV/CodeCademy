package com.example.codecademy;

import com.example.codecademy.Domain.Course;
import com.example.codecademy.Repository.CourseRepository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TestDatabaseConnectionMain {
    public static void main(String[] args) {
        System.out.println("begin database test");
        CourseRepository course = new CourseRepository();
        String str="2015-03-31";
        Date date=Date.valueOf(str);
        course.updateCourse("iets",date,"mid","wiskunde");
//        try {
//            ArrayList<Course> courses = course.getCourses();
//            courses.forEach(course1 -> {
//                System.out.println(course1.toString());
//            });
//        } catch (SQLException e){
//            System.out.println(e);
//        }

    }
}
