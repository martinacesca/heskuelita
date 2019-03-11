package com.capgemini.heskuelita.core.beans;


public class Component {

    //Declaration of component atributes
    private long id = 0;

    //Getters and Setters: id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    //Constructor without atributes
    public Component () {
        super ();
    }

    // Constructor ALL Component atributes
    public Component (long id) {
        super();
        this.id = id;
    }

}
