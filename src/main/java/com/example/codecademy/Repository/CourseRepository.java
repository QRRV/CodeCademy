package com.example.codecademy.Repository;
import com.example.codecademy.Domain.*;

import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;

public class CourseRepository {
    public static boolean deleteCourse(String courseID){
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
    public static ArrayList<Course> getCourses() {
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
                returningCourse.setSubject(rsEmp.getString("subject"));
                returningCourse.setIntroductionText(rsEmp.getString("introductionText"));
                returningCourse.setLevel(rsEmp.getString("status"));
                returningCourse.setInterest(rsEmp.getString("recommendedCourse"));
                courses.add(returningCourse);
            }
            //Return employee object
            return courses;
        } catch (SQLException e) {
            System.out.println("While selecting all courses, an error occurred: " + e);
            //Return exception
            try {
                throw e;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static boolean createCourse(String courseID, String subject, String status, String introductionText, String recommendation) {
        String updateStmt =
                "BEGIN\n" + "INSERT INTO Course VALUES('"+ courseID + "','"+subject+"','"+ status +"','"+ introductionText + "','" +recommendation+"')\n"+
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
    public static Boolean updateCourse(String courseID, String subject, String status, String introductionText, String recommendation) {
        String updateStmt =
                "BEGIN\n" + "UPDATE Course set subject = '"+subject+"',status = '"+status+"',introductionText = '"+introductionText+"',recommendedCourse = '"+recommendation+"' WHERE courseName =  '" + courseID + "'" +
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
