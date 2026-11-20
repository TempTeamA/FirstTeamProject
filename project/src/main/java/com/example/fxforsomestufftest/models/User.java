package com.example.fxforsomestufftest.models;

import com.example.fxforsomestufftest.interfaces.ShowInfo;

/**
 * Наш пользователь
 * Поля: имя, пароль, почта
 * Доп поле: возраст
 */

public class User implements ShowInfo {
    private final String name;
    private final String password;
    private final String email;
    private final int age;

    private User(UserBuilder builder){
       this.name = builder.name;
       this.password = builder.password;
       this.email = builder.email;
       this.age = builder.age;
    }

    public String getName() {return name;}
    public String getPassword() {return password;}
    public String getEmail() {return email;}
    public int getAge() {return age;}

    @Override
    public String toString(){
       return "Имя: " + name + ". Возраст: "+ age + ". Почта: " + email + ". Пароль" + password;
    }

    /**
     * Паттерн builder (по заданию) и для упрощенного заполнения данных
     */
    public static class UserBuilder{
       private String name;
       private String password;
       private String email;
       private int age;

       public  UserBuilder setName(String name) {this.name = name; return this;}
       public  UserBuilder setPass(String password) {this.password = password; return this;}
       public  UserBuilder setMail(String email) {this.email = email;return this;}
       public  UserBuilder setAge(int age) {this.age = age;return this;}

       public User build(){
          return new User(this);
       }
    }
}
