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

    @Override
    public void insertStudent(Student student) throws SQLException{

        try {


            String SQL = "INSERT INTO student2( stu_name, stu_last_name, stu_birthdate, stu_document_type, " +
                    "stu_identification, stu_phone, stu_sex, stu_city, stu_adress, stu_zipcode)"
                    + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = this.conn.prepareStatement(SQL);

            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getLastName());
            pstmt.setString(3, student.getBirthdate() );
            pstmt.setString(4, student.getDocumentType());
            pstmt.setString(5, student.getIdentification());
            pstmt.setString(6, student.getPhone());
            pstmt.setString(7, student.getSex()) ;
            pstmt.setString(8, student.getCity());
            pstmt.setString(9, student.getZipcode());
            pstmt.setString(10, student.getAdress());


            pstmt.executeUpdate();


        }catch(SQLException ex){
            System.out.println(ex.getMessage());

        }



    }








}
