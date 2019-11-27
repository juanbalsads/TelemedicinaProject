/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import POJOs.*;
import Persistence.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.*;


/**
 *
 * @author ainhoarey
 */
public class MainAinhoa {
    private static final String algorithm = "DES";
    private static final byte[] array = new byte[256];
    //new Random().nextBytes(array);
    private static final String key = new String(array, Charset.forName("UTF-8"));
    public static void main(String[] args) throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, Exception {
        UserPassword userInfo2 = new UserPassword("ines", "111");
        UserPassword userInfo = new UserPassword("ainhoa", "555");
        UserPassword en = encrypt(userInfo);
        System.out.println(en);
        UserPassword en2 = encrypt(userInfo2);
        System.out.println(en2);
        UserPassword de = decrypt(en);
        System.out.println(de);
    }
    private static UserPassword encrypt(UserPassword encrypted)throws Exception{
        Cipher cipher = Cipher.getInstance(algorithm);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        DESKeySpec keyspec = new DESKeySpec(key.getBytes());
        SecretKey secretKey = secretKeyFactory.generateSecret(keyspec);

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] password = encrypted.getPassword().getBytes();
        byte[] username = encrypted.getUserName().getBytes();
        byte[] encryptedPassword = cipher.doFinal(password);
        byte[] encryptedUsername = cipher.doFinal(username);
        UserPassword encryption = new UserPassword(encryptedUsername.toString(), encryptedPassword.toString());
        return encryption;
    }
    private static UserPassword decrypt(UserPassword decrypted) throws Exception{
        Cipher cipher = Cipher.getInstance(algorithm);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        DESKeySpec keyspec = new DESKeySpec(key.getBytes());
        SecretKey secretKey = secretKeyFactory.generateSecret(keyspec);

        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedPass = decrypted.getPassword().getBytes();
        byte[] encryptedUser = decrypted.getUserName().getBytes();
        byte[] decryptedPassword = cipher.doFinal(encryptedPass);
        byte[] decryptedUsername = cipher.doFinal(encryptedUser);
        UserPassword decryption = new UserPassword(decryptedUsername.toString(), decryptedPassword.toString());
        return decryption;
    }
}