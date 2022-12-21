package com.example.codecademy;

import com.example.codecademy.Domain.Course;
import com.example.codecademy.Domain.Student;
import com.example.codecademy.Repository.CourseRepository;
import com.example.codecademy.Repository.StudentRepository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TestDatabaseConnectionMain {
    public static void main(String[] args) {
        System.out.println("begin database test");

        //CourseRepo
//        CourseRepository course = new CourseRepository();
//        course.updateCourse("spaans","kut taal", "mid", "spaans is een kut taal",null);
//        course.deleteCourse("spaans");
//        course.createCourse("spaans", "kut vak", "high", "scheikunde is een kut vak", "c");
//
//        ArrayList<Course> courses = course.getCourses();
//        courses.forEach(course1 -> {
//            System.out.println(course1.toString());
//        });

        //StudentRepo
        StudentRepository.deleteStudent("test2@gmail.com");
        StudentRepository.createStudent("test2@gmail.com", "Matthijs", "2001-11-11", "m");
        StudentRepository.updateStudent("test2@gmail.com", "test2@gmail.com", "Quinn", "2001-11-11", "m");
        ArrayList<Student> students = StudentRepository.getStudents();
        students.forEach(student -> {
            System.out.println(student.toString());
        });


    }
}
