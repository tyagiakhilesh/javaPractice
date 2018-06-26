package com.akhilesh.learning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class RSAEncryptionTest {

    @Test
    public void testRsaEncryption() throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        RSAEncryption rsaEncryption = new RSAEncryption();
        String input = "Hello World";
        Map<String, Key> keys = rsaEncryption.generateKeys();
        String enM = rsaEncryption.encryptMessage(input, keys.get("private"));
        System.out.println(enM);
        String decM = rsaEncryption.decryptMessage(enM, keys.get("public"));
        Assertions.assertTrue(decM.equals(input));

        enM = rsaEncryption.encryptMessage(input, keys.get("public"));
        System.out.println(enM);
        decM = rsaEncryption.decryptMessage(enM, keys.get("private"));
        Assertions.assertTrue(decM.equals(input));
    }

    @Test
    public void testDeterminism() throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        RSAEncryption rsaEncryption = new RSAEncryption();
        String input = "Hello World";
        Map<String, Key> keys = rsaEncryption.generateKeys();
        String enM = rsaEncryption.encryptMessage(input, keys.get("private"));
        String decM = rsaEncryption.decryptMessage(enM, keys.get("public"));
        System.out.println(enM);
        System.out.println(decM);
        Assertions.assertTrue(decM.equals(input));

        String enM1 = rsaEncryption.encryptMessage(input, keys.get("private"));
        String decM1 = rsaEncryption.decryptMessage(enM1, keys.get("public"));
        System.out.println(enM1);
        System.out.println(decM1);
        Assertions.assertTrue(decM.equals(decM1));
        Assertions.assertTrue(enM.equals(enM1));
    }
}
