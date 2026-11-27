package controller.abstractions;

import controller.AppModel;
import controller.Navigator;

/**
 * Для MVC паттерна
 * Контракт для всех контроллеров
 */

public interface BaseController {
    void setModel(AppModel model);
    void setNavigator(Navigator navigator);
}
