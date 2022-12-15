package com.example.codecademy.Repository;
import com.example.codecademy.Domain.*;

import java.sql.ResultSet;
import java.sql.*;

public class CourseRepository {
    DatabaseConnection connection = new DatabaseConnection();
    public boolean deleteCourse(String courseID) {
        if (!connection.connectionIsOpen())
            connection.openConnection();

        boolean result = connection
                .executeSQLDeleteStatement(
                        "DELETE FROM Course WHERE courseName =  '" + courseID + "'");

        connection.closeConnection();

        return result;

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
