package com.cinema.cinema.dto.error;

import lombok.Data;

@Data
public class ErrorDto {
    private final String message;
    private final String description;
    private Throwable exception;
}
