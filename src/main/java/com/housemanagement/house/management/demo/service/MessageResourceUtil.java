package com.housemanagement.house.management.demo.service;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public class MessageResourceUtil {
    public static String getMessage(String code, MessageSource messageSource){
        Locale currentLocale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code,null,currentLocale);
    }
}
