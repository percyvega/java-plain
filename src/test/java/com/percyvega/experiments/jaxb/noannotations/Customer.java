package com.percyvega.experiments.jaxb.noannotations;

/**
 * Created by percy on 1/9/2016.
 */
public class Customer {

    private String firstName;
    private String lastName;
    private Addresses addresses;

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

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }
}