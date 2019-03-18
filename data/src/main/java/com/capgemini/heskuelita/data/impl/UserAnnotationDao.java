package com.capgemini.heskuelita.data.impl;

import com.capgemini.heskuelita.data.IUserDao;
import com.capgemini.heskuelita.data.entity.UserAnnotation;
import com.capgemini.heskuelita.data.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

public class UserAnnotationDao implements IUserDao {


    private static SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger (StudentAnnotationDao.class);


    public UserAnnotationDao(SessionFactory sessionFactory) {
        super();
        this.sessionFactory = sessionFactory;
    }


 //   @DisplayName ("Finding companies by country (Using And)")
    @Override
    public UserAnnotation login(String userName, String password) {
        Session session = null;
        final String filter1 = userName;
        final String filter2 = password;
        UserAnnotation userAnnotation = new UserAnnotation();

        try {

            logger.info ("Getting a session...");
            session = sessionFactory.openSession ();
            logger.info ("Finding user using criteria object...");
            Criterion criterion1 = Restrictions.like ("useName", filter1);
            Criterion criterion2 = Restrictions.like ("password", filter2);
            LogicalExpression andExp = Restrictions.and (criterion1, criterion2);

            List<UserAnnotation> list = (List<UserAnnotation>) session.createCriteria (UserAnnotation.class).
                    add (andExp).list ();
            logger.info (String.format ("Users by user name and password using criteria object executed!"));

      //      Assertions.assertFalse (list.isEmpty (), String.format ("Companies by id and country [%d, %s] using criteria object are empty!!!", filter1, filter2));
     //       logger.info ("Print all companies info.");
     //       list.forEach ( e -> logger.info (e.getName ()));


        } catch (Exception ex) {

            String m = String.format ("Problems executing test %s", ex.getMessage ());
            logger.error (m);
    //        Assertions.assertFalse (Boolean.TRUE, m);

        } finally {

            logger.info ("Closing session...");
            session.close ();
        }

        return userAnnotation;
    }



    public static void setup () {

        sessionFactory = HibernateUtil.getSessionFactory ();
    }

    //   @DisplayName ("Create new meeting")
    @Override
    // VER CONECCION PRIMER LINEA Y SI THORWS O NO
    public void insertUser(UserAnnotation user) throws SQLException {

        // Setup
        //      sessionFactory = HibernateUtil.getSessionJavaConfigFactory();
        setup();


        // Get a session.
        Session session = null;
        Transaction tx = null;
        try {

            logger.info("Getting a session...");
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // Set the data to save.
            logger.info("Creating value to insert...");
            UserAnnotation ua = new UserAnnotation(
                                                    user.getUserName(),
                                                    user.getEmail(),
                                                    user.getPassword()     );
            // Save the data.
            logger.info(String.format("Saving value %s", ua.getUserName()));
            session.save(ua);
            logger.info(String.format("Value %s saved!", ua.getUserName()));

            tx.commit();
            //     Assertions.assertTrue(m.getId() > 0, String.format("Problems creating the new meeting type %s", m.getSubject()));

        } catch (Exception ex) {

            logger.error(ex.getMessage());
            tx.rollback();
            //      Assertions.assertFalse(Boolean.TRUE, "Problems executing the test.");

        } finally {
            session.close();
        }


    }





}
