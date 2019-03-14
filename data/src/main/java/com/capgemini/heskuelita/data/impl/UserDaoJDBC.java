package com.capgemini.heskuelita.data.impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.DataException;
import com.capgemini.heskuelita.data.IUserDao;


public class UserDaoJDBC implements IUserDao{

    private Connection conn;

    public UserDaoJDBC(Connection conn){
        super();
        this.conn = conn;
    }


    @Override
    public User login(String userName, String password) {

        User us = null;
        try {
            Statement stm = this.conn.createStatement ();
            ResultSet resultSet = stm.executeQuery ("SELECT * from users WHERE us_username='" + userName + "' AND us_pw='" + password + "'");

            while (resultSet.next ()) {
                us = new User ();
                us.setUserName (resultSet.getString ("us_username"));
                us.setPassword (resultSet.getString ("us_password"));
                us.setEmail (resultSet.getString ("us_email"));
                break;
            }

        } catch (Exception e) {
            throw new DataException (e);
        }

        if (us == null) {
            throw new DataException ("Usuario " + userName + " desconocido");
        }

        return us;
    }


    public void insertUser(User user) throws SQLException {

        try {

            String SQL = "INSERT INTO users(us_user, us_password, us_email)"
                    + "VALUES (?, ?, ?)";


            PreparedStatement pstmt = conn.prepareStatement(SQL);

            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());

            pstmt.executeUpdate();

        }catch(SQLException ex){

            System.out.println(ex.getMessage());

        }

    }





}
