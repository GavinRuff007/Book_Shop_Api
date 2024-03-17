package com.example.testapi.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookRequest {
    @NotNull(message = "{book.name.is.null}")
    @NotBlank(message = "{book.name.is.blank}")
    private final String name;
    @NotNull(message = "{book.price.is.null}")
    @Min(value = 0 , message = "{price.min}")
    private final Long price;
}
