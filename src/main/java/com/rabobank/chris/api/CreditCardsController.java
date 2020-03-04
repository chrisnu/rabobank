package com.rabobank.chris.api;

import com.rabobank.chris.api.exception.EntityNotFoundException;
import com.rabobank.chris.api.exception.RestExceptionHandler;
import com.rabobank.chris.model.dto.CreditCardDTO;
import com.rabobank.chris.model.entities.CreditCard;
import com.rabobank.chris.service.CreditCardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("credit-cards")
@RestController
public class CreditCardsController extends RestExceptionHandler {

    private CreditCardService creditCardService;
    private ModelMapper modelMapper;

    @Autowired
    public CreditCardsController(CreditCardService creditCardService, ModelMapper modelMapper) {
        this.creditCardService = creditCardService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/{id}")
    public CreditCardDTO getCreditCard(@PathVariable("id") String id) {
        CreditCard creditCard = this.creditCardService
                .findById(Integer.valueOf(id))
                .orElseThrow(() -> new EntityNotFoundException(id, CreditCard.class));

        return this.modelMapper.map(creditCard, CreditCardDTO.class);
    }
}
