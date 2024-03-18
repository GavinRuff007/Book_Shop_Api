package com.example.testapi.service.shoppingCard;

import com.example.testapi.dto.request.ShoppingCardRequest;
import com.example.testapi.dto.response.ShoppingCardResponse;

public interface ShoppingCardService {
    ShoppingCardResponse addShoppingCard(ShoppingCardRequest shoppingCardRequest);
}
