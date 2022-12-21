package com.example.codecademy.Repository;
import com.example.codecademy.Domain.*;

import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;

public class CertificateRepository {
    public static boolean deleteCertificate(int certificateID){
        String updateStmt =
                "BEGIN\n" + "DELETE FROM Certificate WHERE certificateID =  '" + certificateID + "'" +
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

    public static ArrayList<Certificate> getCertificates(){
        String selectStmt = "SELECT * FROM certificate";
        try {
            ResultSet rsEmp = DbUtil.dbExecuteQuery(selectStmt);
            ArrayList<Certificate> certificates = new ArrayList<>();
            while (rsEmp.next()) {
                Certificate returningCertificate = new Certificate();
                returningCertificate.setCertificate(rsEmp.getInt("certificateID"));
                returningCertificate.setGrade(rsEmp.getDouble("grade"));
                returningCertificate.setNameEmployer(rsEmp.getString("nameEmployer"));

                certificates.add(returningCertificate);
            }

            return certificates;
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

    public static boolean createCertificate(int certificateID, int grade, String nameEmployer){
        String updateStmt =
                "BEGIN\n" + "INSERT INTO Certificate VALUES('"+ certificateID + "','"+grade+"','"+ nameEmployer +"')\n"+
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
    }

    public static Boolean updateCertificate(int certificateID, int grade, String nameEmployer){
        String updateStmt =
                "BEGIN\n" + "UPDATE Certificate set certificateID = '"+certificateID+"',grade = '"+grade+"',nameEmployer = '"+nameEmployer+"' WHERE certificateID =  '" + certificateID + "'" +
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
