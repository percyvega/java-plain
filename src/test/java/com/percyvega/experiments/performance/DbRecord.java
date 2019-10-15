package com.percyvega.experiments.performance;

import java.util.Date;

/**
 * Created by percy on 3/29/2017.
 */
public class DbRecord {
    private boolean available;
    private String address;
    private String addressLine2;
    private Date birthDate;
    private String businessName;
    private String city;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private int savingsAmountInCents;
    private String password;
    private String note;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public int getSavingsAmountInCents() {
        return savingsAmountInCents;
    }

    public void setSavingsAmountInCents(int savingsAmountInCents) {
        this.savingsAmountInCents = savingsAmountInCents;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "DbRecord{" +
                "available=" + available +
                ", address='" + address + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", birthDate=" + birthDate +
                ", businessName='" + businessName + '\'' +
                ", city='" + city + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", savingsAmountInCents=" + savingsAmountInCents +
                ", password='" + password + '\'' +
//                ", note='" + note + '\'' +
                '}';
    }
}
