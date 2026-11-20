package com.example.fxforsomestufftest;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

public class AppModel {

    private final StringProperty someText = new SimpleStringProperty("");
    // ObservableList - для хранения пользователей в программе
    private ObservableList<User> users = FXCollections.observableArrayList();

    public StringProperty someTextProperty(){
        return someText;
    }

    public String getSomeText(){
        return someText.get();
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
