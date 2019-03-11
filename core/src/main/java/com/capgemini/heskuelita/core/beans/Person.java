package com.capgemini.heskuelita.core.beans;

import java.time.LocalDate;

public class Person extends Component{

    //Declaration of Person atributes
    private String name;
    private String lastName;
    private String birthdate;
    private String documentType;
    private String identification;
    private String phone;
    private String sex;
    private String city;
    private String adress;
    private String zipcode;

    // Getters and Setters: Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getters and Setters: LastName
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getters and Setters: Birthdate
    public String getBirthdate() {
        return birthdate;
    }
    public void setBirthdate (String birthdate) {
        this.birthdate = birthdate;
    }

    // Getters and Setters: DocumentType
    public String getDocumentType() {
        return documentType;
    }
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    // Getters and Setters: Identification
    public String getIdentification() {
        return identification;
    }
    public void setIdentification (String identification) {
        this.identification = identification;
    }

    // Getters and Setters: Phone
    public String getPhone() {
        return phone;
    }
    public void setPhone (String phone) {
        this.phone = phone;
    }

    // Getters and Setters: Sex
    public String getSex() {
        return sex;
    }
    public void setSex (String sex) {
        this.sex = sex;
    }

    // Getters and Setters: City
    public String getCity() {
        return city;
    }
    public void setCity (String city) {
        this.city = city;
    }

    // Getters and Setters: Adress
    public String getAdress() {
        return adress;
    }
    public void setAdress (String adress) {
        this.adress = adress;
    }

    // Getters and Setters: Zipcode
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode (String zipcode) {
        this.zipcode = zipcode;
    }

    //Constructor without atributes
    public Person () {
        super ();
    }

    // Constructor ALL Person atributes
    public Person(long id, String name, String lastName, String birthdate, String documentType,
                  String identification, String phone, String sex, String city, String adress, String zipcode) {
        super(id);
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.documentType = documentType;
        this.identification = identification;
        this.phone = phone;
        this.sex = sex;
        this.city = city;
        this.adress = adress;
        this.zipcode = zipcode;
    }

}
