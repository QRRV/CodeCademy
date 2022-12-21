package com.example.codecademy;

import com.example.codecademy.Domain.Certificate;
import com.example.codecademy.Domain.Course;
import com.example.codecademy.Repository.CertificateRepository;
import com.example.codecademy.Repository.CourseRepository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TestDatabaseConnectionMain {
    public static void main(String[] args) {
        System.out.println("begin database test van certificate");
        //CourseRepository course = new CourseRepository();
        //String str="2015-03-31";
        //Date date=Date.valueOf(str);
        //course.updateCourse("spaans","kut taal", "mid", "spaans is een kut taal",null);
        //course.deleteCourse("spaans");
        //course.createCourse("spaans", "kut vak", "high", "scheikunde is een kut vak", "c");
        CertificateRepository certificate = new CertificateRepository();
        ArrayList<Certificate> certificates = certificate.getCertificates();
        //courses.forEach(course1 -> {
        //    System.out.println(course1.toString());
        //});
        certificate.deleteCertificate(3233);
        certificates.forEach(certicate1 -> {
            System.out.println(certicate1.toString());
        });



      //  certificate.updateCertificate(3233,7,"octo tortelinnie");

    }
}
