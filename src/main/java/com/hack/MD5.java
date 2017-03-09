package com.hack;

import java.security.MessageDigest;
import java.util.Scanner;

public class MD5 {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        try {
            MessageDigest md5 = MessageDigest.getInstance("SHA-256");
            md5.update(str.getBytes());
            // return bytesToHex(md.digest
            byte[] digest = md5.digest();
            for (byte b : digest) {
                System.out.printf("%02x", b);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}