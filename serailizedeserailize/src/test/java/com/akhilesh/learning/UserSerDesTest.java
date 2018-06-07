package com.akhilesh.learning;

import org.apache.commons.io.serialization.ValidatingObjectInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class UserSerDesTest {

    @Test
    public void testSerDes() {
        User u = new User("akhilesh", "tyagi", 1, new Date(), "embeddedString", "base");
        try(FileOutputStream fOS = new FileOutputStream("user.ser");
            ObjectOutputStream oOS = new ObjectOutputStream(fOS)) {
            oOS.writeObject(u);
            fOS.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception while acquiring resources.");
            Assertions.fail();
        }

        try(FileInputStream fIS = new FileInputStream("user.ser");
            ValidatingObjectInputStream oIS = new ValidatingObjectInputStream(fIS)) {
            oIS.accept(User.class, Embedded.class, Base.class);
            User user = (User) oIS.readObject();
            Assertions.assertTrue(u.getFirstName().equals(user.getFirstName()));
            Assertions.assertTrue(u.getLastName().equals(user.getLastName()));
            Assertions.assertTrue(u.getAccountNumber() == (user.getAccountNumber()));
            Assertions.assertTrue(u.getDateOpened().getTime() == (user.getDateOpened().getTime()));
        } catch (Exception e) {
            Assertions.fail();
        }

        try(FileInputStream fIS = new FileInputStream("user.ser");
            ValidatingObjectInputStream oIS = new ValidatingObjectInputStream(fIS)) {
            oIS.accept(Malicious.class);
            oIS.readObject();
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
}
