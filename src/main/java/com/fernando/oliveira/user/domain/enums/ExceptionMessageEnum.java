package com.fernando.oliveira.user.domain.enums;

import lombok.Getter;

@Getter
public enum ExceptionMessageEnum {

    INTERNAL_SERVER_ERROR("error.generic.internal.server-error"),
    USER_NOT_FOUND_BY_ID("user.not.found.by.id"),
    USER_NOT_FOUND_BY_EMAIL("user.not.found.by.email");
    private  final String messageKey;

    ExceptionMessageEnum(String messageKey){
        this.messageKey = messageKey;
    }

    @Override
    public String toString(){
        return messageKey;
    }
}
