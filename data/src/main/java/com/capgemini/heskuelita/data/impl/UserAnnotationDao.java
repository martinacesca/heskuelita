package com.capgemini.heskuelita.data.impl;

import com.capgemini.heskuelita.data.DataException;
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

/*  User Annotaton DAO
 *  Implements IStudentDao interface
 *
 * */
public class UserAnnotationDao implements IUserDao {

    private static SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger (StudentAnnotationDao.class);


    public UserAnnotationDao(SessionFactory sessionFactory) {
        super();
        this.sessionFactory = sessionFactory;
    }

    /*  User Login
     *  This function verifies the user name and password are correct,
      * compareing with the saved information.
     * */
    @Override
    public UserAnnotation login(String userName, String password) {

        Session session = null;
        final String filter1 = userName;
        final String filter2 = password;
        UserAnnotation userAnnotation = null;

        try {

            logger.info ("Getting a session...");
            session = sessionFactory.openSession ();
            logger.info ("Finding user using criteria object...");
            Criterion criterion1 = Restrictions.like ("userName", filter1);
            Criterion criterion2 = Restrictions.like ("password", filter2);
            LogicalExpression andExp = Restrictions.and (criterion1, criterion2);

            List<UserAnnotation> list = (List<UserAnnotation>) session.createCriteria (UserAnnotation.class).
                    add (andExp).list ();

            if (!list.isEmpty()) {
                for (UserAnnotation e : list) {
                    userAnnotation = new UserAnnotation();
                    userAnnotation.setUserName(e.getUserName());
                }
            }

            logger.info (String.format ("Users by user name and password using criteria object executed!"));

        } catch (Exception ex) {

            String m = String.format ("Problems executing test %s", ex.getMessage ());
            logger.error (m);

        } finally {

            logger.info ("Closing session...");
            session.close ();

        }


        if (userAnnotation == null) {
            throw new DataException("Usuario " + userName + " desconocido");
        }

        return userAnnotation;
    }


    public static void setup () {
        sessionFactory = HibernateUtil.getSessionFactory ();
    }


    /*  Insert User
     *  This function inserts a new user row in the postgres table
     * */    @Override
    public void insertUser(UserAnnotation user) throws SQLException {

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

        } catch (Exception ex) {

            logger.error(ex.getMessage());
            tx.rollback();

        } finally {

            session.close();

        }


    }


}
