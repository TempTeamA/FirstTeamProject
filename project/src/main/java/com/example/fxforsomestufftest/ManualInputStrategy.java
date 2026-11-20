package com.example.fxforsomestufftest;

import com.example.fxforsomestufftest.interfaces.InputStrategy;
import com.example.fxforsomestufftest.models.User;

public class ManualInputStrategy implements InputStrategy {
    private final String name, password, email;
    private final int age;
    
    public ManualInputStrategy(String name, String password, String email, int age){
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
    }
    
    @Override
    public User getUser(){
        return new User.UserBuilder()
                .setName(name)
                .setPass(password)
                .setMail(email)
                .setAge(age).build();
    }
    
}
