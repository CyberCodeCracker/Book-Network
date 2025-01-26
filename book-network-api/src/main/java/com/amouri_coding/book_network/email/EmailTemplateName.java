package com.amouri_coding.book_network.email;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum EmailTemplateName {

    ACTIVATE_ACCOUNT("activate_account")

    ;
    private final String name;
    EmailTemplateName(String name) {
        this.name = name;
    }
}
