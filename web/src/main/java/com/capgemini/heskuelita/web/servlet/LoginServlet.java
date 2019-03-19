package com.capgemini.heskuelita.web.servlet;

import com.capgemini.heskuelita.data.entity.UserAnnotation;
import com.capgemini.heskuelita.data.impl.UserAnnotationDao;
import com.capgemini.heskuelita.data.util.HibernateUtil;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.impl.SecurityServiceImpl;
import org.hibernate.SessionFactory;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet ("/login")
public class LoginServlet extends HttpServlet {

    private ISecurityService securityService;

    public LoginServlet (){
        super();
    }

    /*  init
     *  starts the connection
     *  */
    @Override
    public void init (ServletConfig config) throws ServletException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            this.securityService = new SecurityServiceImpl (new UserAnnotationDao(sessionFactory));
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }



    /*  do post
     *  Get information from the login form, verifies its
     *  autenticity,and redirect error or home
     *  */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserAnnotation user = new UserAnnotation ();
        user.setUserName (req.getParameter("userName"));
        user.setPassword (req.getParameter("password"));

        try {

            this.securityService.login(user);
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect("home.jsp");

        } catch (Exception e){

            e.printStackTrace();
            resp.sendRedirect("err.jsp");

        }
    }

}
