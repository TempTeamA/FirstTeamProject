package controller;

/**
 * Для MVC паттерна
 * Хранит данные
 */

public class AppModel {
    private String currentObjectType = "Пользователь";
    public String getCurrentObjectType(){
        return currentObjectType;
    }
    public void setCurrentObjectType(String currentObjectType){
        this.currentObjectType = currentObjectType;
    }
}
