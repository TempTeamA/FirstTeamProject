package com.example.fxforsomestufftest;

public class Demo {
    public static void main(String[] args){
        System.out.println("Старт программы");
        User user = new User.UserBuilder()
                .setName("User1")
                .setAge(12)
                .setMail("asd@mail.com")
                .setPass("1234").build();
        System.out.println(user.toString());
    }
}
