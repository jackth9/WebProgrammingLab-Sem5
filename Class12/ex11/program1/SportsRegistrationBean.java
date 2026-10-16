package com.sports;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "sportsRegistrationBean")
@RequestScoped
public class SportsRegistrationBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String studentName;
    private String rollNumber;
    private String department;
    private String sportsEvent;
    private String contactNumber;

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sports_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    // Getters and Setters
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSportsEvent() {
        return sportsEvent;
    }

    public void setSportsEvent(String sportsEvent) {
        this.sportsEvent = sportsEvent;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // Action method to handle registration
    public String register() {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "INSERT INTO sports_registration (student_name, roll_number, department, sports_event, contact_number) VALUES (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, studentName);
            ps.setString(2, rollNumber);
            ps.setString(3, department);
            ps.setString(4, sportsEvent);
            ps.setString(5, contactNumber);

            int result = ps.executeUpdate();
            if (result > 0) {
                return "success";
            } else {
                return "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
