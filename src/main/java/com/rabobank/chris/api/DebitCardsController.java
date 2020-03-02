package com.rabobank.chris.api;

import com.rabobank.chris.model.entities.DebitCard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("debit-cards")
@RestController
public class DebitCardsController {

    public DebitCardsController() {
    }

    @GetMapping(path = "{id}")
    public DebitCard getDebitCard(@PathVariable("id") String id) {
        var card = new DebitCard();
        card.setId(id);
        return card;
    }
}
