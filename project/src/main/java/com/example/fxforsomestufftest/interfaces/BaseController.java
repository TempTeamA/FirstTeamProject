package com.example.fxforsomestufftest.interfaces;

import com.example.fxforsomestufftest.models.AppModel;
import com.example.fxforsomestufftest.Navigator;

/**
 * Позволяет Navigator работать с любым контроллером
 */
public interface BaseController {
    void setModel(AppModel model);
    void setNavigator(Navigator navigator);
}
