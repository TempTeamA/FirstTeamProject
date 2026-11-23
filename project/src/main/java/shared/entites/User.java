package shared.entites;

import shared.entites.abstractions.Entity;

public class User extends Entity{

    private String name;
    private String password;
    private String email;
    private int age;

    public User(String name, String password, String email, int age){
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    public int getAge(){
        return age;
    }
}
