package com.rabobank.chris.service;

import com.rabobank.chris.model.dto.*;
import com.rabobank.chris.model.enums.CardType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AggregatorService {

    private final WebClient webClient;
    private final ModelMapper modelMapper;
    private static final String URL_POA = "/power-of-attorneys";
    private static final String URL_POA_DETAIL = "/power-of-attorneys/%s";
    private static final String URL_CREDIT_CARD = "/credit-cards/%s";
    private static final String URL_DEBIT_CARD = "/debit-cards/%s";

    @Autowired
    public AggregatorService(WebClient webClient, ModelMapper modelMapper) {
        this.webClient = webClient;
        this.modelMapper = modelMapper;
    }

    public Flux<AggregateDTO> getAccountsSummary() {
        Flux<PowerOfAttorneyReferencesDTO> attorneyReferences = webClient.get()
                .uri(URL_POA)
                .retrieve()
                .bodyToFlux(PowerOfAttorneyReferencesDTO.class);

        Flux<PowerOfAttorneyDTO> powerOfAttorneyDTOFlux = attorneyReferences.flatMap(
                references -> getAttorney(references.getId())
        );

        Flux<List<CardDTO>> cardsFlux = powerOfAttorneyDTOFlux.concatMap(attorney -> getCards(attorney.getCards()));

        return powerOfAttorneyDTOFlux.zipWith(cardsFlux, (attorney, cards) -> {
            AggregateDTO map = modelMapper.map(attorney, AggregateDTO.class);
            map.setCards(cards);

            return map;
        });
    }

    private Mono<PowerOfAttorneyDTO> getAttorney(String id) {
        return webClient.get()
                .uri(String.format(URL_POA_DETAIL, id))
                .retrieve()
                .bodyToMono(PowerOfAttorneyDTO.class);
    }

    private Mono<List<CardDTO>> getCards(List<CardReferenceDTO> referenceDTOS) {
        return Flux.fromIterable(referenceDTOS)
                .concatMap(card -> {
                    if (card.getType().equals(CardType.CREDIT_CARD)) {
                        return getCreditCard(card.getId());
                    }
                    return getDebitCard(card.getId());
                }).collectList();
    }

    private Mono<? extends CardDTO> getCards(CardReferenceDTO referenceDTO) {
        if (referenceDTO.getType().equals(CardType.CREDIT_CARD)) {
            return getCreditCard(referenceDTO.getId());
        }

        return getDebitCard(referenceDTO.getId());
    }

    private Mono<CreditCardDTO> getCreditCard(Integer id) {
        return webClient.get()
                .uri(String.format(URL_CREDIT_CARD, id))
                .retrieve()
                .bodyToMono(CreditCardDTO.class);
    }

    private Mono<DebitCardDTO> getDebitCard(Integer id) {
        return webClient.get()
                .uri(String.format(URL_DEBIT_CARD, id))
                .retrieve()
                .bodyToMono(DebitCardDTO.class);
    }
}
