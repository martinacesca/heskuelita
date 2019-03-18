package com.capgemini.heskuelita.data.entity;


import javax.persistence.*;

@Entity(name = "Student")
@Table(name = "student2")
public class StudentAnnotation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "student_seq")
    @SequenceGenerator(name = "student_seq", sequenceName = "student_seq")
    @Column(name = "stu_id", nullable = false, unique = true)
    private int id;

    @Column(name = "stu_name", length = 20)
    private String name;

    @Column(name = "stu_last_name", length = 20)
    private String lastName;

    @Column(name = "stu_birthdate", length = 50)
    private String birthdate;

    @Column(name = "stu_document_type", length = 20)
    private String documentType;

    @Column(name = "stu_identification", length = 50)
    private String identification;

    @Column(name = "stu_phone", length = 50)
    private String phone;

    @Column(name = "stu_sex", length = 50)
    private String sex;

    @Column(name = "stu_city", length = 100)
    private String city;

    @Column(name = "stu_adress", length = 100)
    private String adress;

    @Column(name = "stu_zipcode", length = 50)
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
    public StudentAnnotation () {
        super ();
    }

    // Constructor ALL student atributes EXCEPT ID.
    public StudentAnnotation( String name, String lastName, String birthdate, String documentType,
                   String identification, String phone, String sex, String city, String adress, String zipcode) {

        super();
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

    // Constructor ALL student atributes
    public StudentAnnotation( int id, String name, String lastName, String birthdate, String documentType,
                   String identification, String phone, String sex, String city, String adress, String zipcode) {

        super();
        this.id = id;
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
