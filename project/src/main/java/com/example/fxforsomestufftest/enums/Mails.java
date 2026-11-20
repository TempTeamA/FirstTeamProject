package com.example.fxforsomestufftest.enums;

import java.util.Arrays;

/**
 * Храним данные для проверки какие почты можно использовать для заполнения
 */
public enum Mails {
    // Google
    GMAIL("@gmail.com"),
    GOOGLEMAIL("@googlemail.com"),

    // Яндекс
    YANDEX_RU("@yandex.ru"),
    YA_RU("@ya.ru"),
    YANDEX_COM("@yandex.com"),
    YANDEX_BY("@yandex.by"),
    YANDEX_KZ("@yandex.kz"),

    // Mail.ru
    MAIL_RU("@mail.ru"),
    INBOX_RU("@inbox.ru"),
    LIST_RU("@list.ru"),
    BK_RU("@bk.ru"),

    // Рамблер
    RAMBLER_RU("@rambler.ru"),
    LENTA_RU("@lenta.ru"),
    AUTORAMBLER_RU("@autorambler.ru"),
    MYRAMBLER_RU("@myrambler.ru"),

    // Microsoft
    OUTLOOK("@outlook.com"),
    HOTMAIL("@hotmail.com"),
    LIVE("@live.com"),
    MSN("@msn.com"),

    // Apple
    ICLOUD("@icloud.com"),
    ME("@me.com"),
    MAC("@mac.com"),

    // Yahoo
    YAHOO("@yahoo.com"),
    YMAIL("@ymail.com"),

    // Защищенные почты
    PROTON_ME("@proton.me"),
    PROTONMAIL("@protonmail.com"),
    PM_ME("@pm.me"),
    TUTA_COM("@tuta.com"),
    TUTA_IO("@tuta.io"),
    TUTANOTA("@tutanota.com");

    private final String domain;

    Mails(String domain){
        this.domain = domain;
    }

    public String getDomain(){
        return domain;
    }
    public static boolean isValidDomain(String email){
        if (email == null){
            return false;
        }
        String lowerCaseEmail = email.toLowerCase();
        return Arrays.stream(values())
                .anyMatch(mails -> lowerCaseEmail.endsWith(mails.getDomain()));
    }
}
