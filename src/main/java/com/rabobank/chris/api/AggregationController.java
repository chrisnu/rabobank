package com.rabobank.chris.api;

import com.rabobank.chris.model.dto.AggregateDTO;
import com.rabobank.chris.service.AggregatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RequestMapping("aggregate")
@RestController
public class AggregationController {

    private final AggregatorService aggregatorService;

    @Autowired
    public AggregationController(AggregatorService aggregatorService) {
        this.aggregatorService = aggregatorService;
    }

    @GetMapping
    public Flux<AggregateDTO> getOverview() {
        return aggregatorService.getAccountsSummary();
    }


}
