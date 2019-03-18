package com.capgemini.heskuelita.data;

import com.capgemini.heskuelita.data.entity.StudentAnnotation;

import java.sql.SQLException;

public interface IStudentDao {

    void insertStudent (StudentAnnotation student) throws SQLException;

}
