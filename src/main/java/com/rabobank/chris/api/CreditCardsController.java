package com.rabobank.chris.api;

import com.rabobank.chris.api.exception.EntityNotFoundException;
import com.rabobank.chris.api.exception.RestExceptionHandler;
import com.rabobank.chris.model.entities.CreditCard;
import com.rabobank.chris.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("credit-cards")
@RestController
public class CreditCardsController extends RestExceptionHandler {

    private CreditCardService creditCardService;

    @Autowired
    public CreditCardsController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping(path = "/{id}")
    public CreditCard getCreditCard(@PathVariable("id") String id) {
        return this.creditCardService
                .findById(Integer.valueOf(id))
                .orElseThrow(() -> new EntityNotFoundException(id, CreditCard.class));
    }
}
