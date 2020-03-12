package com.programmingbasics.exception;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class ExceptionInfo {
    private String exceptionMessage;
    private LocalDateTime localDateTime;

    public ExceptionInfo(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
        this.localDateTime = LocalDateTime.now();
    }
}
