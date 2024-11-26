package com.example.libraryserver.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegistrationRequest {

    @NotEmpty(message = "Имя пользователя не должно быть пустым")
    private String username;

    @NotEmpty(message = "Пароль не должен быть пустым")
    private String password;

    @NotEmpty(message = "Подтверждение пароля не должно быть пустым")
    private String confirmPassword;

    @NotEmpty(message = "Email не должен быть пустым")
    private String email;
    // Дополнительные поля, например, email, можно добавить при необходимости
}
