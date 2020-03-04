package com.rabobank.chris.util;

import com.rabobank.chris.model.converter.CreditCardDTOConverter;
import com.rabobank.chris.model.converter.DebitCardDTOConverter;
import com.rabobank.chris.model.converter.PowerOfAttorneyDTOConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new CreditCardDTOConverter());
        modelMapper.addConverter(new DebitCardDTOConverter());
        modelMapper.addConverter(new PowerOfAttorneyDTOConverter());

        return modelMapper;
    }
}
