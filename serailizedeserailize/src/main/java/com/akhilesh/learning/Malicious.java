package com.akhilesh.learning;

import java.util.Date;

public class Malicious {

    private static final long serialVersionUID = 7829136421241571166L;

    private String firstName;
    private String lastName;
    private int accountNumber;
    private Date dateOpened;

    public Malicious(String firstName, String lastName, int accountNumber, Date dateOpened) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.dateOpened = dateOpened;
    }

    public Malicious() {
        super();
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String aNewFirstName) {
        firstName = aNewFirstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(String aNewLastName) {
        lastName = aNewLastName;
    }

    public final int getAccountNumber() {
        return accountNumber;
    }

    public final void setAccountNumber(int aNewAccountNumber) {
        accountNumber = aNewAccountNumber;
    }

    public final Date getDateOpened() {
        return new Date(dateOpened.getTime());
    }

    public final void setDateOpened(Date aNewDate) {
        Date newDate = new Date(aNewDate.getTime());
        dateOpened = newDate;
    }
}
