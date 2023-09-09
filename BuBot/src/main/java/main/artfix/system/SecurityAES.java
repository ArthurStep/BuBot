package main.artfix.system;

import main.artfix.Application;
import main.artfix.MainConfig;
import main.artfix.other.SystemAutoReset;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


public class SecurityAES {

    public static String encrypt(String originalString) {
        try {
            byte[] keyBytes = MainConfig.KEY.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedBytes = cipher.doFinal(originalString.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            System.out.println("System ERROR! -> Encrypt");
            SystemAutoReset.start();
            Application.applicationWorking = false;
        }
        return originalString;
    }

    public static String decrypt(String encryptedString) {
        try {
            byte[] keyBytes = MainConfig.KEY.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedString);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes);
        } catch (Exception e) {
            System.out.println("System ERROR! -> Decrypt");
            SystemAutoReset.start();
            Application.applicationWorking = false;
        }
        return encryptedString;
    }

}
