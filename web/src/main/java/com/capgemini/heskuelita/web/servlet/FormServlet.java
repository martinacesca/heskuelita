package com.capgemini.heskuelita.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;

import com.capgemini.heskuelita.data.entity.StudentAnnotation;
import com.capgemini.heskuelita.data.entity.UserAnnotation;
import com.capgemini.heskuelita.data.impl.UserAnnotationDao;
import org.hibernate.SessionFactory;

import com.capgemini.heskuelita.data.impl.StudentAnnotationDao;
import com.capgemini.heskuelita.data.util.HibernateUtil;


/*  Form Servlet
 *  extends HttpServlet
 *
 *  */
@WebServlet("/form")
public class FormServlet extends HttpServlet {

    private UserAnnotationDao userAnnotationDao;
    private StudentAnnotationDao studentAnnotationDao;

    public FormServlet(){
        super();
    }

    /*  init
     *  starts the connection and
     *  inicializates studentAnnotationDao and userAnottationDao
     *  */
    @Override
    public void init (ServletConfig config) throws ServletException{

        SessionFactory manager = HibernateUtil.getSessionFactory();
        this.studentAnnotationDao = new StudentAnnotationDao(manager);
        this.userAnnotationDao = new UserAnnotationDao(manager);

    }

    /*  do post
     *  Get information from the form and adds it in a
     *  StudentAnottation and UserAnottation object
     *  */
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse res) throws IOException{

        StudentAnnotation student = new StudentAnnotation();
        UserAnnotation user = new UserAnnotation();

        try{
            student.setName(req.getParameter("name"));
            student.setLastName(req.getParameter("lastName"));
            student.setBirthdate(req.getParameter("birthdate"));
            student.setDocumentType(req.getParameter("documentType"));
            student.setIdentification(req.getParameter("identification"));
            student.setPhone(req.getParameter("phone"));
            student.setSex(req.getParameter("sex"));
            student.setCity(req.getParameter("city"));
            student.setAdress(req.getParameter("adress"));
            student.setZipcode(req.getParameter("zipcode"));

            user.setEmail(req.getParameter("email"));
            user.setUserName(req.getParameter("userName"));
            user.setPassword(req.getParameter("password"));

            studentAnnotationDao.insertStudent (student);
            userAnnotationDao.insertUser (user);

        }catch(SQLException e){

            e.printStackTrace();

        }

        res.sendRedirect("success.jsp");

    }

}



