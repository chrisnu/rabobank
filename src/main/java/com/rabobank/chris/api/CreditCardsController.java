package com.rabobank.chris.api;

import com.rabobank.chris.model.entities.CreditCard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("credit-cards")
@RestController
public class CreditCardsController {

    public CreditCardsController() {
    }

    @GetMapping(path = "{id}")
    public CreditCard getCreditCard(@PathVariable("id") String id) {
        var card = new CreditCard();
        card.setId(id);
        return card;
    }
}
