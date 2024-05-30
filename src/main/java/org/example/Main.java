package org.example;

import dataAccess.UserDAO;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        User user = new User(1 , "ali" , "pppp") ;
//        User user1 = new User(2 , "mmd" , "pmghjg") ;
//        User user2 = new User(3 , "loli" , "789") ;
//        User user3 = new User(4 , "sadegh" , "234") ;
//        User user4 = new User(5 , "shapur" , "000") ;
//        User user5 = new User(6 , "pop" , "8888") ;
//        UserDAO.insertUser(user1);
//        UserDAO.insertUser(user2);
//        UserDAO.insertUser(user3);
//        UserDAO.insertUser(user4);
//        UserDAO.insertUser(user5);
//        UserDAO.insertUser(user);
        System.out.println(UserDAO.serach("pop").getPassWord()) ;




//        System.out.println(UserDAO.serach("kir").getPassWord()) ;




    }
}