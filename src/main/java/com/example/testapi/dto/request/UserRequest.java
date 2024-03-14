package com.example.testapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor

public class UserRequest {
    @NotNull(message = "{username.is.null}")
    @NotBlank(message = "{username.is.blank}")
    private final String username;

    @NotNull(message = "{password.is.null}")
    @NotBlank(message = "{password.is.blank}")
    private final String password;
}
