package com.example.fxforsomestufftest.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Передается во все контроллеры через Navigator
 * для JavaFX для автоматического обновления UI
 */
public class AppModel {
    // Строка для уведомления об изменениях (через bind() Label обновится сам)
    private final StringProperty someText = new SimpleStringProperty("");

    // ObservableList - для хранения пользователей в программе
    private final ObservableList<User> users = FXCollections.observableArrayList();

    public StringProperty someTextProperty(){
        return someText;
    }

    public void setSomeText(String text){
        this.someText.set(text);
    }

    public void addUser(User user){
        this.users.add(user);
    }
    public ObservableList<User> getUsers(){
        return users;
    }
}
