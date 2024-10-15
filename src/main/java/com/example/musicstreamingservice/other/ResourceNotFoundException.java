package com.example.musicstreamingservice.other;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Указываем, что при возникновении этого исключения будет возвращен статус 404

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message); // Вызываем конструктор родительского класса с сообщением
    }
}
