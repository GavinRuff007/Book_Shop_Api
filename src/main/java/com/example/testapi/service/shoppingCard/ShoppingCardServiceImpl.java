package com.example.testapi.service.shoppingCard;

import com.example.testapi.dto.request.ShoppingCardRequest;
import com.example.testapi.dto.response.ShoppingCardResponse;
import com.example.testapi.exception.RuleException;
import com.example.testapi.model.*;
import com.example.testapi.repository.BookRep;
import com.example.testapi.repository.FactorRep;
import com.example.testapi.repository.ShoppingCardRep;
import com.example.testapi.repository.UserRep;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class ShoppingCardServiceImpl implements ShoppingCardService {

    private final FactorRep factorRep;

    private final ShoppingCardRep shoppingCardRep;

    private final UserRep userRep;

    private final BookRep bookRep;

    public ShoppingCardServiceImpl(FactorRep factorRep, ShoppingCardRep shoppingCardRep, UserRep userRep, BookRep bookRep) {
        this.factorRep = factorRep;
        this.shoppingCardRep = shoppingCardRep;
        this.userRep = userRep;
        this.bookRep = bookRep;
    }

    @Override
    @Transactional
    public ShoppingCardResponse addShoppingCard(ShoppingCardRequest shoppingCardRequest) {
            User user = userRep.findById(shoppingCardRequest.getUserId())
                    .orElseThrow(() -> new RuleException("user.not.exist"));
            Book book = bookRep.findById(shoppingCardRequest.getBookId())
                    .orElseThrow(() -> new RuleException("book.not.found"));
           Optional<Factor> byId =  factorRep.findByUserAndPayed(user, Payed.UNPAYED);
           Factor factor;
        factor = byId.orElseGet(() -> createFactor(user));
        factorRep.save(factor);
        ShoppingCard shoppingCard = createShoppingCard(shoppingCardRequest,book,factor);
        return createShoppingCardResponse(shoppingCardRep.save(shoppingCard));

    }

    private ShoppingCardResponse createShoppingCardResponse(ShoppingCard shoppingCard) {
        return   ShoppingCardResponse.builder()
                .factorId(shoppingCard.getFactor().getId())
                .shoppingCard(shoppingCard.getId())
                .build();


    }

    private ShoppingCard createShoppingCard(ShoppingCardRequest shoppingCardRequest, Book book, Factor factor){
        return ShoppingCard.builder()
                    .book(book)
                    .factor(factor)
                    .count(shoppingCardRequest.getCount())
                    .build();

    }

    private Factor createFactor(User user){
        return Factor.builder()
                .user(user)
                .payed(Payed.UNPAYED)
                .build();
    }
}
