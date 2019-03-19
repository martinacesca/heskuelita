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


/*  Student Annotaton DAO
 *  Implements IStudentDao interface
 *
 * */
public class StudentAnnotationDao implements IStudentDao {


    private static SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger (StudentAnnotationDao.class);


    public StudentAnnotationDao(SessionFactory sessionFactory){
        super();
        this.sessionFactory = sessionFactory;
    }


    public static void setup () {
        sessionFactory = HibernateUtil.getSessionFactory ();
    }


    /*  Insert Student
     *  This function inserts a new student row in the postgres table
     * */
    @Override
    public void insertStudent(StudentAnnotation student) throws SQLException {

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

        } catch (Exception ex) {

            logger.error(ex.getMessage());
            tx.rollback();

        } finally {

            session.close();

        }


    }


}
