package com.capgemini.heskuelita.data.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

import com.capgemini.heskuelita.core.beans.Student;
import com.capgemini.heskuelita.data.DataException;
import com.capgemini.heskuelita.data.IStudentDao;
import com.capgemini.heskuelita.data.IUserDao;


public class StudentDaoJDBC implements IStudentDao {


    private Connection conn;

    public StudentDaoJDBC(Connection conn){
        super();
        this.conn = conn;
    }


    public static Connection connect() throws SQLException {
        final String url = "jdbc:postgresql://localhost/postgres";
        final String user = "postgres";
        final String password = "kira1234";
        return DriverManager.getConnection(url, user, password);
    }

    public void insertStudent(Student student) {

        String SQL = "INSERT INTO student(stu_id, stu_name, stu_last_name, stu_birthdate, stu_document_type, stu_identification, stu_phone, stu_sex, stu_city, stu_adress, stu_zipcode, stu_active)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        long id = student.getId () +1;
        student.setId(id);

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setLong(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getLastName());
            pstmt.setString(4, null );
            pstmt.setString(5, student.getDocumentType());
            pstmt.setString(6, student.getIdentification());
            pstmt.setString(7, student.getPhone());
            pstmt.setString(8, String.valueOf(student.getSex()) );
            pstmt.setString(9, student.getCity());
            pstmt.setString(10, student.getAdress());
            pstmt.setString(11, student.getZipcode());


            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }








}
