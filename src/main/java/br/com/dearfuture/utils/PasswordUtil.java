package br.com.dearfuture.utils;



import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class PasswordUtil {
    
    private static String secretKey = "e933c0b198c2463b881ee92adc1d926c";
    private static String salt = "conditionevaluationunchanged";

    public static String encrypt(String text) {
        text = String.format("%s%s", text, salt);
        byte[] raw;
        String encryptedString;
        SecretKeySpec skeySpec;
        byte[] encryptText = text.getBytes();
        Cipher cipher;
        try {
            raw = Base64.decodeBase64(secretKey);
            skeySpec = new SecretKeySpec(raw, "AES");
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            encryptedString = Base64.encodeBase64String(cipher.doFinal(encryptText));
            return encryptedString;
        } 
        catch (Exception e) {
            throw new RuntimeException();
        }
    }


}
