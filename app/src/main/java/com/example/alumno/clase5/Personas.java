package com.example.alumno.clase5;

/**
 * Created by alumno on 04/10/2018.
 */

public class Personas {

    private String firstName;
    private String lastName;
    private String phone;

    public Personas()
    {

    }

    public Personas(String fn, String ln, String phone)
    {
        this.firstName = fn;
        this.lastName = fn;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
