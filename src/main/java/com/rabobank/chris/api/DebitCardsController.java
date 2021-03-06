package com.rabobank.chris.api;

import com.rabobank.chris.api.exception.EntityNotFoundException;
import com.rabobank.chris.model.dto.DebitCardDTO;
import com.rabobank.chris.model.entities.DebitCard;
import com.rabobank.chris.service.DebitCardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RequestMapping("debit-cards")
@RestController
public class DebitCardsController {

    private final DebitCardService debitCardService;
    private final ModelMapper modelMapper;

    @Autowired
    public DebitCardsController(DebitCardService debitCardService, ModelMapper modelMapper) {
        this.debitCardService = debitCardService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "{id}")
    public DebitCardDTO getCreditCard(@PathVariable("id") @NotBlank Integer id) {
        final DebitCard debitCard = debitCardService
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, DebitCard.class));

        return modelMapper.map(debitCard, DebitCardDTO.class);
    }
}
