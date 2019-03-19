package com.capgemini.heskuelita.data;

import com.capgemini.heskuelita.data.entity.UserAnnotation;

import java.sql.SQLException;


public interface IUserDao {

    UserAnnotation login (String userName, String password);
    void insertUser (UserAnnotation userAnnotation) throws SQLException;

}
