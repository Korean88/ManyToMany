package com.epam.webshop.users;

import com.epam.webshop.utils.PasswordEncoder;

/**
 * Created by Andrey Yun on 16.02.14.
 */
public class Runner {

    public static void main(String[] args) {
        String passwordHash = PasswordEncoder.sha2Encode("testPass1221212");
        System.out.println(passwordHash);
    }

}
