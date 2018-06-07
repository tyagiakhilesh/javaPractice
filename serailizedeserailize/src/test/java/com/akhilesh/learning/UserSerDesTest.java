package com.akhilesh.learning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class UserSerDesTest {

    @Test
    public void testSerDes() {
        User u = new User("akhilesh", "tyagi", 1, new Date());
        try(FileOutputStream fOS = new FileOutputStream("user.ser");
            ObjectOutputStream oOS = new ObjectOutputStream(fOS)) {
            oOS.writeObject(u);

        } catch (IOException e) {
            System.out.println("Exception while acquiring resources.");
        }

        try(FileInputStream fIS = new FileInputStream("user.ser");
            ObjectInputStream oIS = new ObjectInputStream(fIS)) {
            User user = (User) oIS.readObject();
            Assertions.assertTrue(u.getFirstName().equals(user.getFirstName()));
            Assertions.assertTrue(u.getLastName().equals(user.getLastName()));
            Assertions.assertTrue(u.getAccountNumber() == (user.getAccountNumber()));
            Assertions.assertTrue(u.getDateOpened().getTime() == (user.getDateOpened().getTime()));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Exception while acquiring resources.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found for User.");
        }
    }
}
