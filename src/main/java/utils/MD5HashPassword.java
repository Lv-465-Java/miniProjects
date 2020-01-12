package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashPassword {

    private static final int MD5_PASSWORD_LENGTH=16;

    public static String hashPassword(String password){
        String hashWord=null;

        try {
            MessageDigest messageDigest=MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            BigInteger hash=new BigInteger(1,messageDigest.digest());
            hashWord=hash.toString(MD5_PASSWORD_LENGTH);
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        } return hashWord;
    }
}
