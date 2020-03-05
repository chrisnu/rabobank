package com.rabobank.chris.util;

import com.rabobank.chris.model.converter.CreditCardDTOConverter;
import com.rabobank.chris.model.converter.DebitCardDTOConverter;
import com.rabobank.chris.model.converter.PowerOfAttorneyDTOConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ApplicationConfig {

    @Value("${external.endpoint.url}")
    private String EXTERNAL_API_ENDPOINT;

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new CreditCardDTOConverter());
        modelMapper.addConverter(new DebitCardDTOConverter());
        modelMapper.addConverter(new PowerOfAttorneyDTOConverter());

        return modelMapper;
    }

    @Bean
    public WebClient webClient() {
        return WebClient.create(EXTERNAL_API_ENDPOINT);
    }
}
