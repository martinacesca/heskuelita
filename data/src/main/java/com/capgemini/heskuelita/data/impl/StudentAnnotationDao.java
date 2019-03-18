package com.capgemini.heskuelita.data.impl;

import java.sql.*;

import com.capgemini.heskuelita.data.IStudentDao;
import com.capgemini.heskuelita.data.entity.StudentAnnotation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.capgemini.heskuelita.data.util.HibernateUtil;



public class StudentAnnotationDao implements IStudentDao {


    private static SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger (StudentAnnotationDao.class);


    public StudentAnnotationDao(SessionFactory sessionFactory){
        super();
        this.sessionFactory = sessionFactory;
    }
/*
    public HibernateXMLTest () {

        super ();
    }


    @BeforeAll
    public static void setup () {

        sessionFactory = HibernateUtil.getSessionFactory ();
    }

    @AfterAll
    public static void destroy () {

        sessionFactory.close ();
    }

    */

    public static void setup () {

        sessionFactory = HibernateUtil.getSessionFactory ();
    }


    //   @DisplayName ("Create new meeting")
    @Override
    // VER CONECCION PRIMER LINEA Y SI THORWS O NO
    public void insertStudent(StudentAnnotation student) throws SQLException {

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
            StudentAnnotation sa = new StudentAnnotation(
                                                        student.getName(),
                                                        student.getLastName(),
                                                        student.getBirthdate(),
                                                        student.getDocumentType(),
                                                        student.getIdentification(),
                                                        student.getPhone(),
                                                        student.getSex(),
                                                        student.getCity(),
                                                        student.getZipcode(),
                                                        student.getAdress()     );
            // Save the data.
            logger.info(String.format("Saving value %s", sa.getName()));
            session.save(sa);
            logger.info(String.format("Value %s saved!", sa.getName()));

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
