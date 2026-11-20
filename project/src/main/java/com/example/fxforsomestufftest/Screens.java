package com.example.fxforsomestufftest;

public enum Screens {
    MAIN_MENU("main-menu.fxml", "Главное меню"),
    WRITE_MENU_COOSE("write-menu.fxml", "Выбор способа ввода"),
    WRITE_HAND_MENU("handInputInfo-menu.fxml","Ручной ввод"),
    READ_MENU("read-menu.fxml", "Список");

    private final String fxmlFile;
    private final String title;

    Screens(String fxmlFile, String title) {
        this.fxmlFile = fxmlFile;
        this.title = title;
    }

    public String getFxmlFile(){
        return fxmlFile;
    }
    public String getTitle(){
        return title;
    }
}
