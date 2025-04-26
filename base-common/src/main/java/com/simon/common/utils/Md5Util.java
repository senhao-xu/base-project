package com.simon.common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Md5Util {

    public Md5Util() {
    }

    public static String md5(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes("UTF-8"));
            return bytesToHex(md5.digest());
        } catch (Exception var2) {
            throw new RuntimeException(var2);
        }
    }

    public static String md5slat(String str) {
        return Md5Util.md5(Md5Util.md5("7Fr1&uOg" + str + "%7Dmv5$t"));
    }

    public static String bytesToHex(byte[] bytes) {
        BigInteger bigInt = new BigInteger(1, bytes);
        String hashtext;
        for (hashtext = bigInt.toString(16); hashtext.length() < 32; hashtext = "0" + hashtext) {
        }
        return hashtext;
    }
}
