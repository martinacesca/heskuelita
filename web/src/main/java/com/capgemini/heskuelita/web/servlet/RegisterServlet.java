package com.capgemini.heskuelita.web.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;



import com.capgemini.heskuelita.core.beans.Student;
import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.IStudentDao;
import com.capgemini.heskuelita.data.IUserDao;
import com.capgemini.heskuelita.data.db.DBConnectionManager;
import com.capgemini.heskuelita.data.impl.StudentDaoJDBC;
import com.capgemini.heskuelita.data.impl.UserDaoJDBC;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.impl.SecurityServiceImpl;
import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.PreparedStatement;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {


    private ISecurityService securityService;
    private IUserDao userDao;
    private IStudentDao studentDao;

    public RegisterServlet (){
        super();
    }

    @Override
    public void init (ServletConfig config) throws ServletException{

        ServletContext context = config.getServletContext();

        DBConnectionManager manager = (DBConnectionManager) context.getAttribute("db");


        //?????????????????????
        //?????????????????????
        try {

            this.securityService = new SecurityServiceImpl(new UserDaoJDBC(manager.getConnection()));

        } catch (Exception e) {

            throw new ServletException(e);
        }
    }


    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse res) throws IOException {

        Student student = new Student();
        User user = new User();

        student.setName(req.getParameter("name"));
        student.setLastName(req.getParameter("lastName"));
        student.setBirthdate(req.getParameter("birthdate"));
        student.setDocumentType(req.getParameter("documentType"));
        student.setIdentification(req.getParameter("identification"));
        student.setPhone(req.getParameter("phone"));
        student.setSex(req.getParameter("sex"));
        student.setCity(req.getParameter("city"));
        student.setAdress(req.getParameter("address"));
        student.setZipcode(req.getParameter("zipcode"));

        user.setEmail(req.getParameter("email"));
        user.setUserName(req.getParameter("userName"));
        user.setPassword(req.getParameter("password"));

        try{
            studentDao.insertStudent (student);
            userDao.insertUser (user);
        }catch(SQLException e){
            res.sendRedirect("err.jsp");
        }

    }

}



