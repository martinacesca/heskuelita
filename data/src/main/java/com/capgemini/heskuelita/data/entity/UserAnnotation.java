package com.capgemini.heskuelita.data.entity;


import javax.persistence.*;


@Entity (name =  "User")
@Table (name = "users")
public class UserAnnotation {


    @Id
    @GeneratedValue (strategy = GenerationType.AUTO, generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq")
    @Column (name="us_id", nullable=false, unique=true)
    private int id;

    @Column(name="us_name", length=50, nullable=false)
    private String userName;

    @Column(name="us_email", length=50, nullable=false)
    private String email;

    @Column(name="us_password", length=20, nullable=false)
    private String password;





    public int getId () {

        return this.id;
    }

    public void setId (int id) {

        this.id = id;
    }

    public String getUserName () {

        return this.userName;
    }

    public void setUserName (String userName) {

        this.userName = userName;
    }

    public String getEmail () {

        return this.email;
    }

    public void setEmail (String email) {

        this.email = email;
    }

    public String getPassword () {

        return this.password;
    }

    public void setPassword (String password) {

        this.password = password;
    }



    //Constructor without atributes
    public UserAnnotation () {

        super ();
    }


    // Constructor ALL Usr atributes EXCEPT ID.
    public UserAnnotation (String userName, String email, String password) {

        super ();
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    // Constructor ALL User atributes
    public UserAnnotation (int id, String userName, String email, String password) {

        super ();

        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

}
