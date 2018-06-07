package com.akhilesh.learning;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private static final long serialVersionUID = 7829136421241571165L;

    private String firstName;
    private String lastName;
    private int accountNumber;
    private Date dateOpened;
    private Embedded embedded;

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

    public User(String firstName, String lastName, int accountNumber, Date dateOpened, String embedded, String base) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.dateOpened = dateOpened;
        this.embedded = new Embedded(embedded, base);

    }

    public User() {
        super();
    }

    public final String getFirstName() {
        return firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final int getAccountNumber() {
        return accountNumber;
    }

    public final Date getDateOpened() {
        return new Date(dateOpened.getTime());
    }

    public final void setFirstName(String aNewFirstName) {
        firstName = aNewFirstName;
    }

    public final void setLastName(String aNewLastName) {
        lastName = aNewLastName;
    }

    public final void setAccountNumber(int aNewAccountNumber) {
        accountNumber = aNewAccountNumber;
    }

    public final void setDateOpened(Date aNewDate) {
        Date newDate = new Date(aNewDate.getTime());
        dateOpened = newDate;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        firstName = objectInputStream.readUTF();
        lastName = objectInputStream.readUTF();
        accountNumber = objectInputStream.readInt();
        dateOpened = new Date(objectInputStream.readLong());
        embedded = (Embedded) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(firstName);
        objectOutputStream.writeUTF(lastName);
        objectOutputStream.writeInt(accountNumber);
        objectOutputStream.writeLong(dateOpened.getTime());
        objectOutputStream.writeObject(embedded);
    }
}