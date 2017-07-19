package com.xiaomi.example.domain.utils;

import sun.misc.BASE64Encoder;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by mi on 2017/3/20.
 */
public class SecurityUtils {
    public static String md5AndBase64Encrypt(String password){
        String newStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            newStr = base64Encoder.encode(md5.digest(password.getBytes()));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            return newStr;
        }
    }

    public static boolean md5AndBase64Validate(String newPassword, String oldPassword){
        if(md5AndBase64Encrypt(newPassword).equals(oldPassword) ) {
            return true;
        } else {
            return false;
        }
    }

    public static String md5Encrypt(String password){
        String newStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(password.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return (new BigInteger (md5.digest())).toString(16);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
