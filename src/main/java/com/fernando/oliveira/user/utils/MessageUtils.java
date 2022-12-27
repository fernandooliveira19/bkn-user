package com.fernando.oliveira.user.utils;


import com.fernando.oliveira.user.domain.enums.ExceptionMessageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageUtils {

    @Autowired
    private MessageSource messageSource;

    MessageUtils(MessageSource messageSource){
        this.messageSource = messageSource;
    }
    public String getMessage(ExceptionMessageEnum message){
        return messageSource.getMessage(message.toString(), null, LocaleContextHolder.getLocale());
    }
    public String getMessage(String property, Object[] args){
        return messageSource.getMessage(property, args, LocaleContextHolder.getLocale());
    }

}
