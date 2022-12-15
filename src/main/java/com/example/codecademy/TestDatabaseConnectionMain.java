package com.example.codecademy;

import com.example.codecademy.Repository.CourseRepository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestDatabaseConnectionMain {
    public static void main(String[] args) {
        System.out.println("begin database test");
        CourseRepository course = new CourseRepository();
        String str="2015-03-31";
        Date date=Date.valueOf(str);
        course.createCourse("scheikunde",date,"high","engels");
    }
}
