package com.example.fxforsomestufftest.enums;

/**
 * Хранение информации о разметке и названии окна
 * Если их будет много, просто расширяем enum
 */
public enum Screens {
    MAIN_MENU("views/main-menu.fxml", "Главное меню"),
    WRITE_MENU_COOSE("views/write-menu.fxml", "Выбор способа ввода"),
    WRITE_HAND_MENU("views/handInputInfo-menu.fxml","Ручной ввод"),
    READ_MENU("views/read-menu.fxml", "Список");

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
