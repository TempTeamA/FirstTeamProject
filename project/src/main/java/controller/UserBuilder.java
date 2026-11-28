package controller;

import shared.entites.User;

public class UserBuilder {
	private String name;
	private String password;
	private String email;
	private int age;
	
    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setAge(int age){
        this.age = age;
        return this;
    }
    
    
    public User build() {
    	return new User(name, password, email, age);
    }
}
