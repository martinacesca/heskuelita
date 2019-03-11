package com.capgemini.heskuelita.core.beans;

import java.time.LocalDate;
import java.util.*;

public class Student extends Person {


    // Constructor without atributes
    public Student () {
        super();
    }


    // Constructor ALL Student atributes
    public Student(long id, String name, String lastName, String birthdate, String documentType,
                  String identification, String phone, String sex, String city, String adress, String zipcode) {

        super (id, name, lastName, birthdate, documentType, identification, phone, sex, city, adress, zipcode);

    }

}
