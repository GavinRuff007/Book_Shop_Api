package com.example.testapi.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ShoppingCardRequest {
    @NotNull(message = "{user.id.is.null}")
    private Long userId;

    @NotNull(message = "{book.id.is.null}")
    private Long bookId;

    @NotNull(message = "{user.id.is.null}")
    @Min(value = 1,message = "{count.not.valid}")
    private Integer count;
}
