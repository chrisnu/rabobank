package com.rabobank.chris.api;

import com.rabobank.chris.api.exception.EntityNotFoundException;
import com.rabobank.chris.model.entities.DebitCard;
import com.rabobank.chris.service.DebitCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("debit-cards")
@RestController
public class DebitCardsController {

    private DebitCardService debitCardService;

    @Autowired
    public DebitCardsController(DebitCardService debitCardService) {
        this.debitCardService = debitCardService;
    }

    @GetMapping(path = "{id}")
    public DebitCard getCreditCard(@PathVariable("id") String id) {
        return this.debitCardService
                .findById(Integer.valueOf(id))
                .orElseThrow(() -> new EntityNotFoundException(id, DebitCard.class));
    }
}
