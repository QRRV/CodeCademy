package com.example.codecademy.Repository;
import com.example.codecademy.Domain.*;

import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;

public class CourseRepository {
    public boolean deleteCourse(String courseID){
        String updateStmt =
                "BEGIN\n" + "DELETE FROM Course WHERE courseName =  '" + courseID + "'" +
                        "END;";
        //Execute UPDATE operation
        try {
            DbUtil.dbExecuteUpdate(updateStmt);
            return true;
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            try {
                throw e;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public ArrayList<Course> getCourses() throws SQLException {
        String selectStmt = "SELECT * FROM course";
        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DbUtil.dbExecuteQuery(selectStmt);
            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            ArrayList<Course> courses = new ArrayList<>();
            while (rsEmp.next()) {
                Course returningCourse = new Course();
                returningCourse.setCourseName(rsEmp.getString("courseName"));
                returningCourse.setSubject("TODO");
                returningCourse.setIntroductionText("TODO");
                returningCourse.setLevel(rsEmp.getString("status"));
                returningCourse.setInterest(rsEmp.getString("recommendedCourse"));
                courses.add(returningCourse);
            }
            //Return employee object
            return courses;
        } catch (SQLException e) {
            System.out.println("While selecting all courses, an error occurred: " + e);
            //Return exception
            throw e;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean createCourse(String courseID,Date dateTime,String level, String recommandation) {
        String updateStmt =
                "BEGIN\n" + "INSERT INTO Course VALUES('"+ courseID + "','"+dateTime+"','"+level+"','"+recommandation+"')\n"+
                        "END;";
        //Execute DELETE operation
        try {
            DbUtil.dbExecuteUpdate(updateStmt);
            return true;
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            try {
                throw e;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
//

    }
    public boolean updateCourse(String courseID,Date dateTime,String level, String recommandation) {
        String updateStmt =
                "BEGIN\n" + "UPDATE Course set date = '"+dateTime+"',status = '"+level+"',recommendedCourse = '"+recommandation+"' WHERE courseName =  '" + courseID + "'" +
                        "   COMMIT;\n" +
                        "END;";
        //Execute UPDATE operation
        try {
            DbUtil.dbExecuteUpdate(updateStmt);
            return true;
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            try {
                throw e;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
