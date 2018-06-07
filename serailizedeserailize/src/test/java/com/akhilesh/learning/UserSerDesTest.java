package com.akhilesh.learning;

import org.apache.commons.io.serialization.ValidatingObjectInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class UserSerDesTest {

    @Test
    public void testSerDes() {
        User u = new User("akhilesh", "tyagi", 1, new Date(), "embeddedString", "base");
        try (FileOutputStream fOS = new FileOutputStream("user.ser");
             ObjectOutputStream oOS = new ObjectOutputStream(fOS)) {
            oOS.writeObject(u);
            fOS.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception while acquiring resources.");
            Assertions.fail();
        }

        try (FileInputStream fIS = new FileInputStream("user.ser");
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

        try (FileInputStream fIS = new FileInputStream("user.ser");
             ValidatingObjectInputStream oIS = new ValidatingObjectInputStream(fIS)) {
            oIS.accept(Malicious.class);
            oIS.readObject();
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void testSerDesForCollection() {
        User u1 = new User("akhilesh", "tyagi", 1, new Date(), "embeddedString", "base");
        User u2 = new User("akhilesh", "tyagi", 1, new Date(), "embeddedString", "base");
        List<User> users = new ArrayList(2);
        users.add(u1);
        users.add(u2);
        try (FileOutputStream fOS = new FileOutputStream("users.ser");
             ObjectOutputStream oOS = new ObjectOutputStream(fOS)) {
            oOS.writeObject(users);
            fOS.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception while acquiring resources.");
            Assertions.fail();
        }

        try (FileInputStream fIS = new FileInputStream("users.ser");
             ValidatingObjectInputStream oIS = new ValidatingObjectInputStream(fIS)) {
            oIS.accept(User.class, Embedded.class, Base.class, ArrayList.class, LinkedList.class);
            List<User> usersList = (List<User>) oIS.readObject();
            Assertions.assertTrue(usersList.size() == 2);
            User user = usersList.get(0);
            Assertions.assertTrue(u1.getFirstName().equals(user.getFirstName()));
            Assertions.assertTrue(u1.getLastName().equals(user.getLastName()));
            Assertions.assertTrue(u1.getAccountNumber() == (user.getAccountNumber()));
            Assertions.assertTrue(u1.getDateOpened().getTime() == (user.getDateOpened().getTime()));
        } catch (Exception e) {
            Assertions.fail();
        }

        try (FileInputStream fIS = new FileInputStream("users.ser");
             ValidatingObjectInputStream oIS = new ValidatingObjectInputStream(fIS)) {
            oIS.accept(Malicious.class);
            oIS.readObject();
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
}
