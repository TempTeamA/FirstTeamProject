package com.example.fxforsomestufftest.models;
/**
Объект для переноса данных
 Вводим сырые данные для проверки и дальнейшего добавления в список
 */
public class UserDto {
    private final String name;
    private final String age;  // Чтоб потом проверить и перевезти в int
    private final String email;
    private final String password;

    public UserDto(String name, String age, String email, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public String getName(){return name;}
    public String getAge() {return age;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}
}
