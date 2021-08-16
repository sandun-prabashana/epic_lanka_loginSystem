/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.login.security;

import com.sun.istack.internal.logging.Logger;
import java.security.Key;
import java.util.Scanner;
import java.util.logging.Level;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author MCTech
 */
public class AES {

    private static final String ALGO = "AES";
    private byte[] keyValue;
    
    public AES(String key){
        keyValue =key.getBytes();
    }
    
    public String encrypt(String Data) throws Exception{
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }
    
    public String decrypt(String encryptedData)throws Exception{
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    
    private Key generateKey() throws Exception{
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
                
    }
    
    public static void main(String[] args) {
        
        
//        try {
//            AES aes = new AES("gtevdywoap12gryd");
//            Scanner my = new Scanner(System.in);
//            String secret = my.nextLine();
//            String encdata = aes.encrypt(secret);
//            System.out.println("Encrypted Data - "+encdata);
//            String decdata =  aes.decrypt(encdata);
//            System.out.println("Decrypted Data - "+decdata);
//        } catch (Exception ex) {
//            java.util.logging.Logger.getLogger(AES.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
    }
    
}
