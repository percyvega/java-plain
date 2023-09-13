package com.percyvega.experiments.performance;

import lombok.Data;

import java.util.Date;

@Data
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
}
