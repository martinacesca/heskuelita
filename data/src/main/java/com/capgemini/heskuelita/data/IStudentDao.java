package com.capgemini.heskuelita.data;

import com.capgemini.heskuelita.core.beans.Student;

import java.sql.SQLException;

public interface IStudentDao {

    void insertStudent (Student student) throws SQLException;

}
