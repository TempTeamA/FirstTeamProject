package com.example.fxforsomestufftest.interfaces;

import com.example.fxforsomestufftest.models.User;

/*
Для выбора стратегии как вносить данные
Ручной ввод, случайнеы данные, из файла
 */
public interface InputStrategy {
    User getUser();
}

