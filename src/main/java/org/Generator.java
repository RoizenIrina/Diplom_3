package org;

import java.util.Random;


public class Generator {
    static String login = "something" + new Random().nextInt(10000);
    static String email = "something" + new Random().nextInt(10000) + "@yandex.ru";
    static String password = "something" + new Random().nextInt(10000);


    public static String getLogin() {
//        int i;
//        for (i = 1; i <= 100; i = i + 1) ;
//        login = login + i;
        return login;
    }

    public static String getEmail() {
//        int i;
//        for (i = 1; i <= 100; i = i + 1) ;
//        email = i + email;
        return email;
    }

    public static String getPassword() {
//        int i;
//        for (i = 1; i <= 100; i = i + 1) ;
//        password = password + i;
        return password;
    }






}
