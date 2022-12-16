package com.example.codecademy.Repository;
import com.example.codecademy.Domain.*;

import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;

public class CourseRepository {
    static DatabaseConnection connection = new DatabaseConnection();
    public boolean deleteCourse(String courseID) {
        if (!connection.connectionIsOpen())
            connection.openConnection();

        boolean result = connection
                .executeSQLDeleteStatement(
                        "DELETE FROM Course WHERE courseName =  '" + courseID + "'");

        connection.closeConnection();

        return result;

    }
    public static ArrayList<Course> getCourses() throws SQLException {
        if (!connection.connectionIsOpen())
            connection.openConnection();

        ResultSet result = connection
                .executeSQLSelectStatement("SELECT * FROM course");


        ArrayList<Course> courses = new ArrayList<>();
        while (result.next()) {
            Course returningCourse = new Course();
            returningCourse.setCourseName(result.getString("courseName"));
            returningCourse.setSubject("TODO");
            returningCourse.setIntroductionText("TODO");
            returningCourse.setLevel(result.getString("status"));
            returningCourse.setInterest(result.getString("recommendedCourse"));

            courses.add(returningCourse);
        }
        connection.closeConnection();
        return courses;
    }
    public boolean createCourse(String courseID,Date dateTime,String level, String recommandation) {
        if (!connection.connectionIsOpen())
            connection.openConnection();

        boolean result = connection
                .executeSQLDeleteStatement(" INSERT INTO Course "+ "VALUES('"+ courseID +"','"+dateTime+"','"+level+"','"+recommandation+"')");

        connection.closeConnection();

        return result;

    }

}
